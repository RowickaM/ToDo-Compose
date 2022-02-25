package pl.gungnir.todo.ui.screen.category.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.todo.R
import pl.gungnir.todo.ui.theme.Gray
import pl.gungnir.todo.ui.theme.White
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun DateHeader(
    modifier: Modifier = Modifier,
    date: LocalDate
) = Text(
    modifier = modifier
        .fillMaxWidth()
        .background(White)
        .padding(vertical = 16.dp, horizontal = 16.dp),
    text = date.getStringDate(),
    style = MaterialTheme.typography.overline,
    color = Gray
)

@Composable
private fun LocalDate.getStringDate(): String {
    val now = LocalDate.now()

    return when (this) {
        now -> stringResource(id = R.string.today)
        now.plusDays(1) -> stringResource(id = R.string.tomorrow)
        now.minusDays(1) -> stringResource(id = R.string.yesterday)
        else -> this.format(DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH))
            .replaceFirstChar { it.uppercase() }
    }
}

@Preview
@Composable
fun DateHeaderPreview() {
    DateHeader(
        date = LocalDate.now()
    )
}