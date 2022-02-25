package pl.gungnir.todo.ui.components.targetItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pl.gungnir.todo.R
import pl.gungnir.todo.ui.components.getPlurals
import pl.gungnir.todo.ui.theme.DarkGray
import pl.gungnir.todo.ui.theme.Gray
import pl.gungnir.todo.ui.theme.Orange

@Composable
fun CategoryInfo(
    modifier: Modifier = Modifier,
    categoryName: String,
    taskCount: Int,
    progress: Float,
    color: Color
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = getPlurals(resId = R.plurals.task_count_header, quantity = taskCount),
            color = Gray
        )
        Text(
            text = categoryName,
            style = MaterialTheme.typography.h4,
            color = DarkGray
        )
        ProgressBar(
            progress = progress,
            color = color
        )
    }
}

@Preview
@Composable
fun CategoryInfoPreview() {
    CategoryInfo(
        categoryName = "Personal",
        taskCount = 1,
        progress = 0.5f,
        color = Orange
    )
}