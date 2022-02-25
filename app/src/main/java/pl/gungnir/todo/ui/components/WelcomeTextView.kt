package pl.gungnir.todo.ui.components

import androidx.annotation.PluralsRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pl.gungnir.todo.R
import pl.gungnir.todo.ui.theme.White

@Composable
fun WelcomeTextView(
    modifier: Modifier = Modifier,
    name: String,
    taskCount: Int
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.welcome_name, name),
            style = MaterialTheme.typography.h4,
            color = White
        )
        Text(
            text = stringResource(id = R.string.welcome_subtitle),
            color = White.copy(alpha = 0.4f)
        )
        Text(
            text = getPlurals(resId = R.plurals.task_count, quantity = taskCount),
            color = White.copy(alpha = 0.4f)
        )
    }
}

@Preview
@Composable
fun WelcomeTextViewPreview() {
    Column {
        WelcomeTextView(taskCount = 2, name = "Jane")
        WelcomeTextView(taskCount = 3, name = "Jane")
    }
}

@Composable
fun getPlurals(
    @PluralsRes resId: Int,
    quantity: Int,
): String {
    return LocalContext.current.resources.getQuantityString(resId, quantity, quantity)
}