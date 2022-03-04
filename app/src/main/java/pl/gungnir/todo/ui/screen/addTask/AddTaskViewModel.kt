package pl.gungnir.todo.ui.screen.addTask

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import pl.gungnir.todo.data.model.Category
import pl.gungnir.todo.data.model.Task
import pl.gungnir.todo.domain.usecase.AddTaskUseCase
import pl.gungnir.todo.domain.usecase.GetCategoryUseCase
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class AddTaskViewModel(
    private val addTaskUseCase: AddTaskUseCase,
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {

    private var categoryId = 1
    val task = mutableStateOf(Task())
    val category = mutableStateOf(Category())
    val date = mutableStateOf(getTodayString())
    val errorDate = mutableStateOf<String?>(null)

    fun onInit(categoryId: Int) {
        this.categoryId = categoryId
        getColor()

    }

    fun onNameChange(name: String) {
        task.value = task.value.copy(
            name = name
        )
    }

    fun onExpiryDate(date: String) {
        errorDate.value = null
        if (date.length <= 6) {
            this.date.value = date
        }
    }

    fun onAddClick(onDone: () -> Unit) {
        if (addTask()) {
            onDone()
        }
    }

    private fun addTask(): Boolean {
        if (isDateValid()) {
            return addTaskUseCase.execute(categoryId, this.task.value)
        }
        return false
    }

    private fun getColor() {
        category.value = getCategoryUseCase.execute(categoryId)
    }

    private fun isDateValid(): Boolean {
        val date = this.date.value.chunked(2)
        if (date.isEmpty()) {
            errorDate.value = "Date cannot be empty."
            return false
        }
        if (date.size != 3) {
            errorDate.value = "Date has wrong pattern. Correct is dd/MM/yy."
            return false
        }
        try {
            errorDate.value = null
            task.value = task.value.copy(
                expiryDate = getDateFromString(date)
            )
        } catch (e: DateTimeParseException) {
            errorDate.value = "Date has wrong pattern. Correct is dd/MM/yy."
            return false
        }

        return true
    }

    private fun getDateFromString(date: List<String>): LocalDate {
        return LocalDate.parse(
            date.joinToString(separator = "/"),
            DateTimeFormatter.ofPattern("dd/MM/yy")
        )
    }

    private fun getTodayString(): String {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyy"))
    }
}