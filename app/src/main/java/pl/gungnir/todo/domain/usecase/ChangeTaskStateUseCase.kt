package pl.gungnir.todo.domain.usecase

import pl.gungnir.todo.domain.repository.ToDoRepository

class ChangeTaskStateUseCase(
    private val toDoRepository: ToDoRepository
) {

    fun execute(categoryId: Int, taskId: Int, isDone: Boolean) {
        toDoRepository.setStateTask(categoryId, taskId, isDone)
    }
}