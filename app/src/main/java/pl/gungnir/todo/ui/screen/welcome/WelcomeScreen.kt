package pl.gungnir.todo.ui.screen.welcome

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel
import pl.gungnir.todo.ui.components.AvatarView
import pl.gungnir.todo.ui.components.TodayView
import pl.gungnir.todo.ui.components.WelcomeTextView
import pl.gungnir.todo.ui.components.targetItem.CategoryListItem
import pl.gungnir.todo.ui.theme.White

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    viewModel: WelcomeViewModel = getViewModel(),
    onClick: (categoryId: Int) -> Unit
) {
    val lazyListState = rememberLazyListState()
    val categoryList = remember { viewModel.categoryList.value }
    val allTaskTodayCount = remember { viewModel.allTaskToday.value }

    val animateBackgroundColor = animateColorAsState(
        targetValue = when (lazyListState.firstVisibleItemIndex) {
            0 -> viewModel.getActualColor(0)
            1 -> viewModel.getActualColor(1)
            else -> viewModel.getActualColor(2)
        },
        animationSpec = tween(durationMillis = 600)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = arrayListOf(
                        White,
                        animateBackgroundColor.value
                    ),
                    endY = 600f
                )
            ),
        verticalArrangement = Arrangement.SpaceAround
    ) {

        AvatarView(
            modifier = Modifier.padding(start = 24.dp)
        )
        WelcomeTextView(
            modifier = Modifier.padding(start = 24.dp),
            taskCount = allTaskTodayCount,
            name = "Jane"
        )

        Column {
            TodayView(
                modifier = Modifier.padding(start = 24.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                modifier = Modifier
                    .height(360.dp)
                    .fillMaxWidth(),
                state = lazyListState
            ) {
                item {
                    Spacer(modifier = Modifier.width(24.dp))
                }

                items(categoryList) { category ->
                    CategoryListItem(
                        categoryName = category.name,
                        categoryId = category.id,
                        taskCount = category.todayTaskCount,
                        progress = category.progress,
                        color = category.color,
                        onClick = onClick
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}