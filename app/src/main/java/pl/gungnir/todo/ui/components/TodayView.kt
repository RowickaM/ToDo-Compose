package pl.gungnir.todo.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pl.gungnir.todo.R
import pl.gungnir.todo.ui.parseToday
import pl.gungnir.todo.ui.theme.White
import java.time.LocalDate

@Composable
fun TodayView(
    modifier: Modifier = Modifier,
) = Text(
    modifier = modifier,
    text = stringResource(id = R.string.today_simicolon, LocalDate.now().parseToday().uppercase()),
    color = White,
    style = MaterialTheme.typography.overline
)

@Preview
@Composable
fun TodayViewPreview() {
    TodayView()
}