package pl.gungnir.todo.domain.repository

import pl.gungnir.todo.data.model.Category
import pl.gungnir.todo.data.model.CategoryList
import pl.gungnir.todo.data.model.Task

interface ToDoRepository {

    fun getAllCategoryList(): List<CategoryList>
    fun getCategory(categoryId: Int): Category
    fun addTask(categoryId: Int, task: Task): Boolean
    fun setStateTask(categoryId: Int, taskId: Int, isDone: Boolean)
}