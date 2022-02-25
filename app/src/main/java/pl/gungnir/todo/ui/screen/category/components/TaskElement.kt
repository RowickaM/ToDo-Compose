package pl.gungnir.todo.ui.screen.category.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.todo.data.model.Task
import pl.gungnir.todo.ui.theme.DarkGray
import pl.gungnir.todo.ui.theme.Gray
import pl.gungnir.todo.ui.theme.Orange
import java.time.LocalDate

@Composable
fun TaskElement(
    modifier: Modifier = Modifier,
    task: Task,
    color: Color,
    onTaskStateChange: (Int, Boolean) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = { onTaskStateChange(task.id, it) },
                colors = CheckboxDefaults.colors(
                    checkedColor = color
                )
            )
            Text(
                modifier = modifier.padding(start = 8.dp),
                text = task.name,
                color = DarkGray
            )
        }

        Divider(
            modifier = Modifier.padding(top = 8.dp),
            color = Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskElementPreview() {
    TaskElement(
        task = Task(
            id = 0,
            name = "Task 1",
            isDone = true,
            expiryDate = LocalDate.now()
        ),
        color = Orange,
        onTaskStateChange = { _, _ -> }
    )
}