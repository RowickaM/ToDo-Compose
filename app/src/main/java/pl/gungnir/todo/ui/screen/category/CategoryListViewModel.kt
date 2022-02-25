package pl.gungnir.todo.ui.screen.category

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.gungnir.todo.data.model.Category
import pl.gungnir.todo.data.model.Task
import pl.gungnir.todo.domain.usecase.ChangeTaskStateUseCase
import pl.gungnir.todo.domain.usecase.GetCategoryUseCase
import java.time.LocalDate

class CategoryListViewModel(
    private val getCategoryUseCase: GetCategoryUseCase,
    private val changeTaskStateUseCase: ChangeTaskStateUseCase
) : ViewModel() {

    val category = mutableStateOf<Category?>(null)
    val categoryTasks = mutableStateOf(emptyMap<LocalDate, List<Task>>())

    fun fetchCategory(categoryId: Int) {
        val category = getCategoryUseCase.execute(categoryId)
        this.category.value = category
        spitTaskByDay(category)

    }

    private fun spitTaskByDay(category: Category) {
        categoryTasks.value = category.tasks.groupBy { it.expiryDate }
    }

    fun onTaskStateChange(taskId: Int, isDone: Boolean) {
        viewModelScope.launch {
            val categoryId = category.value?.id ?: return@launch

            changeTaskStateUseCase.execute(
                categoryId = categoryId,
                taskId = taskId,
                isDone = isDone
            )
            fetchCategory(categoryId)
        }
    }
}