package pl.gungnir.todo.domain.usecase

import pl.gungnir.todo.data.model.CategoryList
import pl.gungnir.todo.domain.repository.ToDoRepository

class GetCategoryListUseCase(
    private val toDoRepository: ToDoRepository
) {

    fun execute(): List<CategoryList> {
        return toDoRepository.getAllCategoryList()
    }
}