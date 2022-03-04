package pl.gungnir.todo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pl.gungnir.todo.ui.screen.addTask.AddTaskScreen
import pl.gungnir.todo.ui.screen.category.CategoryListScreen
import pl.gungnir.todo.ui.screen.welcome.WelcomeScreen
import pl.gungnir.todo.ui.theme.ToDoTheme
import pl.gungnir.todo.util.naigation.NavRoutes
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val showFAB = remember { mutableStateOf(false) }
            val catId = remember { mutableStateOf(-1) }

            ToDoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        if (showFAB.value) {
                            FloatingActionButton(
                                onClick = { navController.navigate(NavRoutes.ADD) }
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Add,
                                    contentDescription = "add task"
                                )
                            }
                        }
                    }
                ) { padding ->
                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding),
                        navController = navController,
                        startDestination = NavRoutes.HOME
                    ) {
                        composable(NavRoutes.HOME) {
                            showFAB.value = false
                            WelcomeScreen(
                                onClick = {
                                    navController.navigate(route = NavRoutes.CATEGORY_ARG + it)
                                }
                            )
                        }

                        composable(
                            route = NavRoutes.CATEGORY,
                            arguments = listOf(
                                navArgument(NavRoutes.CATEGORY_ID) {
                                    type = NavType.IntType
                                }
                            ),
                        ) {
                            val categoryId = it.arguments?.getInt(NavRoutes.CATEGORY_ID) ?: -1
                            catId.value = categoryId
                            CategoryListScreen(categoryId = categoryId)
                            showFAB.value = true
                        }

                        composable(
                            route = NavRoutes.ADD
                        ) {
                            showFAB.value = false
                            AddTaskScreen(
                                categoryId = catId.value,
                                onAddedTask = { navController.navigateUp() }
                            )
                        }
                    }
                }
            }
        }
    }
}

fun LocalDate.parseToday(): String {
    return this.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH))
}