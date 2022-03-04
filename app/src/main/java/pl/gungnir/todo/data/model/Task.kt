package pl.gungnir.todo.data.model

import java.time.LocalDate

data class Task(
    val id: Int = 0,
    val name: String = "",
    val isDone: Boolean = false,
    val expiryDate: LocalDate = LocalDate.now()
)
