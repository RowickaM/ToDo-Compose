package pl.gungnir.todo.data.model

import androidx.compose.ui.graphics.Color
import pl.gungnir.todo.ui.theme.Blue

data class Category(
    val id: Int = -1,
    val name: String = "",
    val todayTaskCount: Int = -1,
    val progress: Double = 0.0,
    val color: Color = Blue,
    val tasks: ArrayList<Task> = ArrayList()
)