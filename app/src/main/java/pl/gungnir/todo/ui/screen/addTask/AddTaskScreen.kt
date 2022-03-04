package pl.gungnir.todo.ui.screen.addTask

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel
import pl.gungnir.todo.ui.screen.addTask.components.Info
import pl.gungnir.todo.ui.theme.White

@Composable
fun AddTaskScreen(
    modifier: Modifier = Modifier,
    viewModel: AddTaskViewModel = getViewModel(),
    categoryId: Int,
    onAddedTask: () -> Unit
) {
    LaunchedEffect("onInt") {
        viewModel.onInit(categoryId)
    }

    val task = viewModel.task.value
    val category = viewModel.category.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                value = task.name,
                onValueChange = viewModel::onNameChange,
                label = {
                    Text(
                        text = "What task are you planning to perform?",
                        style = MaterialTheme.typography.caption,
                    )
                },
                colors = OutlinedColor(category.color)
            )

            Info(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                icon = Icons.Outlined.Category,
                iconColor = category.color
            ) {
                Text(
                    text = category.name,
                    color = MaterialTheme.colors.onBackground
                )
            }

            Info(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                icon = Icons.Outlined.DateRange,
                iconColor = category.color,
                error = viewModel.errorDate.value
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.date.value,
                    onValueChange = viewModel::onExpiryDate,
                    colors = OutlinedColor(category.color),
                    visualTransformation = DateTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    isError = !viewModel.errorDate.value.isNullOrBlank(),
                    singleLine = true,
                    maxLines = 1,
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(category.color)
                .align(Alignment.BottomCenter)
                .clickable { viewModel.onAddClick(onAddedTask) },
        ) {
            Icon(
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.Center),
                imageVector = Icons.Outlined.Add,
                contentDescription = "add task",
                tint = White
            )
        }
    }
}

@Composable
fun OutlinedColor(color: Color) = TextFieldDefaults.outlinedTextFieldColors(
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