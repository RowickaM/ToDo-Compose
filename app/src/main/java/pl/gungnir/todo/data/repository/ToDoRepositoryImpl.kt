package pl.gungnir.todo.data.repository

import pl.gungnir.todo.data.model.Category
import pl.gungnir.todo.data.model.CategoryList
import pl.gungnir.todo.data.model.Task
import pl.gungnir.todo.domain.repository.ToDoRepository
import java.math.RoundingMode
import java.time.LocalDate

class ToDoRepositoryImpl : ToDoRepository {

    override fun getAllCategoryList(): List<CategoryList> {
        return categoryListMock
    }

    override fun getCategory(categoryId: Int): Category {
        val mockCategory = when (categoryId) {
            0 -> categoryPersonalMock
            1 -> categoryWorkMock
            else -> categoryHomeMock
        }

        return mockCategory.copy(
            tasks = ArrayList(
                mockCategory.tasks.sortedWith(
                    compareBy(
                        { it.expiryDate },
                        { it.isDone })
                )
            )
        )
    }

    override fun addTask(categoryId: Int, task: Task): Boolean {
        categoryListMock.find { it.id == categoryId } ?: return false
        val newTask = task.copy(id = allTaskCount)
        when (categoryId) {
            0 -> categoryPersonalMock = addTaskToCategory(categoryPersonalMock, newTask)
            1 -> categoryWorkMock = addTaskToCategory(categoryWorkMock, newTask)
            else -> categoryHomeMock = addTaskToCategory(categoryHomeMock, newTask)
        }

        allTaskCount++
        return true
    }

    private fun addTaskToCategory(category: Category, task: Task): Category {
        var newCategory = category
        newCategory.tasks.add(task)

        if (task.expiryDate == LocalDate.now()) {
            val todayTaskCount = newCategory.todayTaskCount + 1
            newCategory = newCategory.copy(
                todayTaskCount = todayTaskCount,
                progress = calculateProgress(todayTaskCount, newCategory.tasks)
            )
        }

        return newCategory
    }

    private fun calculateProgress(allTask: Int, allTasks: ArrayList<Task>): Double {
        val allDoneTaskCount = allTasks
            .filter {
                it.expiryDate == LocalDate.now() && it.isDone
            }.size
        return (allDoneTaskCount.toDouble() / allTask)
            .toBigDecimal()
            .setScale(2, RoundingMode.FLOOR)
            .toDouble()
    }

    override fun setStateTask(categoryId: Int, taskId: Int, isDone: Boolean) {
        when (categoryId) {
            0 -> {
                categoryPersonalMock = editTaskToCategory(categoryPersonalMock, taskId, isDone)
                categoryListMock = updateCategoryListMock(
                    categoryId,
                    categoryPersonalMock.progress
                )
            }
            1 -> {
                categoryWorkMock = editTaskToCategory(categoryWorkMock, taskId, isDone)
                categoryListMock = updateCategoryListMock(
                    categoryId,
                    categoryWorkMock.progress
                )
            }
            else -> {
                categoryHomeMock = editTaskToCategory(categoryHomeMock, taskId, isDone)
                categoryListMock = updateCategoryListMock(
                    categoryId,
                    categoryHomeMock.progress
                )
            }
        }
    }

    private fun editTaskToCategory(category: Category, taskId: Int, isDone: Boolean): Category {
        val task = category.tasks.firstOrNull { it.id == taskId }
        task ?: return category
        var newCategory = category.copy(
            tasks = ArrayList(
                category.tasks.map {
                    if (it.id == taskId) {
                        it.copy(isDone = isDone)
                    } else {
                        it
                    }
                }.sortedWith(compareBy({ it.expiryDate }, { it.isDone }))
            )
        )


        if (task.expiryDate == LocalDate.now()) {
            newCategory = newCategory.copy(
                progress = calculateProgress(newCategory.todayTaskCount, newCategory.tasks)
            )
        }

        return newCategory
    }

    private fun updateCategoryListMock(categoryId: Int, progress: Double): List<CategoryList> {
        return categoryListMock.map {
            if (it.id == categoryId) {
                it.copy(
                    progress = progress,
                )
            } else {
                it
            }
        }
    }
}