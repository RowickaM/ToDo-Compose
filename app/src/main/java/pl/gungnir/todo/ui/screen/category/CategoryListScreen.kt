package pl.gungnir.todo.ui.screen.category

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel
import pl.gungnir.todo.ui.components.targetItem.CategoryInfo
import pl.gungnir.todo.ui.screen.category.components.DateHeader
import pl.gungnir.todo.ui.screen.category.components.TaskElement

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryListScreen(
    modifier: Modifier = Modifier,
    mViewModel: CategoryListViewModel = getViewModel(),
    categoryId: Int
) {
    val categoryData = mViewModel.category
    val categoryTasks = mViewModel.categoryTasks

    LaunchedEffect(key1 = Unit) {
        mViewModel.fetchCategory(categoryId)
    }

    categoryData.value?.let { category ->
        val progressAnim by animateFloatAsState(
            targetValue = category.progress.toFloat(),
            animationSpec = tween(durationMillis = 500)
        )

        Column(
            modifier = modifier.fillMaxSize()
        ) {
            CategoryInfo(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 32.dp),
                categoryName = category.name,
                taskCount = category.todayTaskCount,
                progress = progressAnim,
                color = category.color
            )

            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                categoryTasks.value.forEach { (initial, elements) ->
                    stickyHeader {
                        DateHeader(date = initial)
                    }
                    items(elements) { task ->
                        TaskElement(
                            task = task,
                            color = category.color,
                            onTaskStateChange = mViewModel::onTaskStateChange
                        )
                    }
                }
            }
        }
    }
}