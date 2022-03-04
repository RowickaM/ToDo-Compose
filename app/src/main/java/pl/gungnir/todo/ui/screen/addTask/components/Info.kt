package pl.gungnir.todo.ui.screen.addTask.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.todo.ui.theme.Orange

@Composable
fun Info(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconColor: Color,
    error: String? = null,
    descriptor: @Composable () -> Unit,
) {
    Column {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = iconColor
            )
            Spacer(modifier = Modifier.width(8.dp))
            descriptor()
        }

        error?.let {
            Text(
                modifier = Modifier.padding(start = 32.dp),
                text = error,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.error
            )
        }
    }
}

@Preview
@Composable
fun InfoPreview() {
    Info(
        icon = Icons.Outlined.DateRange,
        iconColor = Orange,
        error = "Error"
    ) {
        Text(text = "Date")
    }
}