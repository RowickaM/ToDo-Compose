package pl.gungnir.todo.domain.usecase

import pl.gungnir.todo.data.model.Task
import pl.gungnir.todo.domain.repository.ToDoRepository

class AddTaskUseCase(
    private val toDoRepository: ToDoRepository
) {

    fun execute(categoryId: Int, task: Task): Boolean {
        return toDoRepository.addTask(categoryId, task)
    }
}