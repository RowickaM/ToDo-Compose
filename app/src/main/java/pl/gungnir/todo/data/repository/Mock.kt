package pl.gungnir.todo.data.repository

import pl.gungnir.todo.data.model.Category
import pl.gungnir.todo.data.model.CategoryList
import pl.gungnir.todo.data.model.Task
import pl.gungnir.todo.ui.theme.Blue
import pl.gungnir.todo.ui.theme.Green
import pl.gungnir.todo.ui.theme.Orange
import java.time.LocalDate

var allTaskCount = 48

val taskUndone = Task(
    id = 0,
    name = "Task 1",
    isDone = false,
    expiryDate = LocalDate.now()
)
val taskDone = Task(
    id = 0,
    name = "Task 1",
    isDone = true,
    expiryDate = LocalDate.now()
)

var categoryListMock = listOf(
    CategoryList(
        id = 0,
        name = "Personal",
        todayTaskCount = 6,
        progress = 0.33,
        color = Orange
    ),
    CategoryList(
        id = 1,
        name = "Work",
        todayTaskCount = 12,
        progress = 0.58,
        color = Blue
    ),
    CategoryList(
        id = 2,
        name = "Home",
        todayTaskCount = 7,
        progress = 0.28,
        color = Green
    ),
)

var categoryPersonalMock = Category(
    id = 0,
    name = "Personal",
    todayTaskCount = 6,
    progress = 0.33,
    color = Orange,
    tasks = arrayListOf(
        taskUndone.copy(id = 1, name = "Task 1"),
        taskUndone.copy(id = 2, name = "Task 2"),
        taskUndone.copy(id = 3, name = "Task 3"),
        taskUndone.copy(id = 4, name = "Task 4"),
        taskDone.copy(id = 5, name = "Task 5"),
        taskDone.copy(id = 6, name = "Task 6"),
        taskUndone.copy(id = 7, name = "Task 7", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 8, name = "Task 8", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 9, name = "Task 9", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 10, name = "Task 10", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 11, name = "Task 11", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 12, name = "Task 12", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 13, name = "Task 13", expiryDate = LocalDate.now().plusDays(2)),
        taskUndone.copy(id = 14, name = "Task 14", expiryDate = LocalDate.now().plusDays(2)),
        taskUndone.copy(id = 15, name = "Task 15", expiryDate = LocalDate.now().plusDays(2)),
    )
)

var categoryWorkMock = Category(
    id = 1,
    name = "Work",
    todayTaskCount = 12,
    progress = 0.58,
    color = Blue,
    tasks = arrayListOf(
        taskUndone.copy(id = 16, name = "Task 16"),
        taskUndone.copy(id = 17, name = "Task 17"),
        taskUndone.copy(id = 18, name = "Task 18"),
        taskUndone.copy(id = 19, name = "Task 19"),
        taskUndone.copy(id = 20, name = "Task 20"),
        taskDone.copy(id = 21, name = "Task 21"),
        taskDone.copy(id = 22, name = "Task 22"),
        taskDone.copy(id = 23, name = "Task 23"),
        taskDone.copy(id = 24, name = "Task 24"),
        taskDone.copy(id = 25, name = "Task 25"),
        taskDone.copy(id = 26, name = "Task 26"),
        taskDone.copy(id = 27, name = "Task 27"),
        taskUndone.copy(id = 28, name = "Task 28", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 29, name = "Task 29", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 30, name = "Task 30", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 31, name = "Task 31", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 32, name = "Task 32", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 33, name = "Task 33", expiryDate = LocalDate.now().plusDays(1)),
    )
)

var categoryHomeMock = Category(
    id = 2,
    name = "Home",
    todayTaskCount = 7,
    progress = 0.28,
    color = Green,
    tasks = arrayListOf(
        taskUndone.copy(id = 34, name = "Task 34"),
        taskUndone.copy(id = 35, name = "Task 35"),
        taskUndone.copy(id = 36, name = "Task 36"),
        taskUndone.copy(id = 37, name = "Task 37"),
        taskUndone.copy(id = 38, name = "Task 38"),
        taskDone.copy(id = 39, name = "Task 39"),
        taskDone.copy(id = 40, name = "Task 40"),
        taskUndone.copy(id = 41, name = "Task 41", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 42, name = "Task 42", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 43, name = "Task 43", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 44, name = "Task 44", expiryDate = LocalDate.now().plusDays(1)),
        taskUndone.copy(id = 45, name = "Task 45", expiryDate = LocalDate.now().plusDays(3)),
        taskUndone.copy(id = 46, name = "Task 46", expiryDate = LocalDate.now().plusDays(3)),
        taskUndone.copy(id = 47, name = "Task 47", expiryDate = LocalDate.now().plusDays(3)),
        taskUndone.copy(id = 48, name = "Task 48", expiryDate = LocalDate.now().plusDays(3)),
    )
)