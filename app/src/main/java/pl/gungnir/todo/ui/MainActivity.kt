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
import pl.gungnir.todo.ui.theme.Blue
import pl.gungnir.todo.ui.theme.ToDoTheme
import pl.gungnir.todo.ui.theme.White
import pl.gungnir.todo.util.naigation.NavRoutes
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {

                    }
                ) { padding ->

                }
            }
        }
    }
}

fun LocalDate.parseToday(): String {
    return this.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH))
}