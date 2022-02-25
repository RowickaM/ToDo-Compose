package pl.gungnir.todo.domain.usecase

import pl.gungnir.todo.data.model.Category
import pl.gungnir.todo.domain.repository.ToDoRepository

class GetCategoryUseCase(
    private val toDoRepository: ToDoRepository
) {

    fun execute(categoryId: Int): Category {
        return toDoRepository.getCategory(categoryId = categoryId)
    }
}