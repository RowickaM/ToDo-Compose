package pl.gungnir.todo.data.model

import java.time.LocalDate

data class Task(
    val id: Int,
    val name: String,
    val isDone: Boolean,
    val expiryDate: LocalDate
)
