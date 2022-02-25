package pl.gungnir.todo.data.model

import androidx.compose.ui.graphics.Color

data class Category(
    val id: Int,
    val name: String,
    val todayTaskCount: Int,
    val progress: Double,
    val color: Color,
    val tasks: ArrayList<Task>
)