package pl.gungnir.todo.ui.components.targetItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.todo.ui.theme.DarkGray
import pl.gungnir.todo.ui.theme.Gray
import pl.gungnir.todo.ui.theme.Orange

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth(0.80f)
                .height(1.dp),
            progress = progress,
            color = color,
            backgroundColor = Gray
        )
        Text(
            text = "${(progress * 100).toInt()}%",
            style = MaterialTheme.typography.overline,
            color = DarkGray
        )
    }
}

@Preview
@Composable
fun ProgressBarPreview() {
    ProgressBar(
        progress = 0.5f,
        color = Orange
    )
}