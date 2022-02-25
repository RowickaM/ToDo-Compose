package pl.gungnir.todo.ui.screen.welcome

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import pl.gungnir.todo.data.model.CategoryList
import pl.gungnir.todo.domain.usecase.GetCategoryListUseCase
import pl.gungnir.todo.ui.theme.White

class WelcomeViewModel(
    private val getCategoryListUseCase: GetCategoryListUseCase
) : ViewModel() {

    val categoryList = mutableStateOf(emptyList<CategoryList>())
    val allTaskToday = mutableStateOf(0)

    init {
        fetchCategoryList()
        calculateAllTaskInToday()
    }

    private fun fetchCategoryList() {
        categoryList.value = getCategoryListUseCase.execute()
    }

    private fun calculateAllTaskInToday() {
        allTaskToday.value = categoryList.value.fold(0) { acc, item ->
            acc + item.todayTaskCount
        }
    }

    fun getActualColor(index: Int): Color = categoryList.value.getOrNull(index)?.color ?: White
}