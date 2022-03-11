package pl.gungnir.todo.ui.screen.category

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.androidx.compose.getViewModel

@Composable
fun CategoryListScreen(
    modifier: Modifier = Modifier,
    mViewModel: CategoryListViewModel = getViewModel(),
    onColorChange: (Color) -> Unit,
    categoryId: Int
) {
    Text(text = "CategoryListScreen")
}