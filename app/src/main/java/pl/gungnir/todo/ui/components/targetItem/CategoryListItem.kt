package pl.gungnir.todo.ui.components.targetItem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.todo.ui.theme.Orange
import pl.gungnir.todo.ui.theme.White

@Composable
fun CategoryListItem(
    modifier: Modifier = Modifier,
    categoryId: Int,
    categoryName: String,
    taskCount: Int,
    progress: Double,
    color: Color,
    onClick: (categoryId: Int) -> Unit = {}
) {
    Column(
        modifier = modifier
            .size(height = 400.dp, width = 250.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = White,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick(categoryId) }
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        CategoryInfo(
            categoryName = categoryName,
            taskCount = taskCount,
            progress = progress.toFloat(),
            color = color
        )
    }
}

@Preview
@Composable
fun CategoryListItemPreview() {
    CategoryListItem(
        categoryName = "Personal",
        categoryId = 0,
        taskCount = 1,
        progress = 0.5,
        color = Orange
    )
}