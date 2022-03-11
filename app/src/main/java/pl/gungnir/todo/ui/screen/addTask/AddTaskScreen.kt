package pl.gungnir.todo.ui.screen.addTask

import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.getViewModel

@Composable
fun AddTaskScreen(
    modifier: Modifier = Modifier,
    viewModel: AddTaskViewModel = getViewModel(),
    categoryId: Int,
    onAddedTask: () -> Unit
) {
    Text(text = "AddTaskScreen")
}

@Composable
fun outlinedColor(color: Color) = TextFieldDefaults.outlinedTextFieldColors(
    cursorColor = color,
    focusedLabelColor = color,
    focusedBorderColor = color
)

@Preview
@Composable
fun AddTaskScreenPreview() {
    AddTaskScreen(
        categoryId = 0,
        onAddedTask = {}
    )
}