package pl.gungnir.todo.data.model

import androidx.compose.ui.graphics.Color

data class CategoryList(
    val id: Int,
    val name: String,
    val todayTaskCount: Int,
    val progress: Double,
    val color: Color
)
