package pl.gungnir.todo.ui.screen.welcome

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    viewModel: WelcomeViewModel = getViewModel(),
    onClick: (categoryId: Int) -> Unit
) {
    Text(text = "WelcomeScreen")
}