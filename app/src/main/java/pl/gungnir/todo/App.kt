package pl.gungnir.todo

import android.app.Application
import org.koin.core.context.startKoin
import pl.gungnir.todo.util.di.repositoryModule
import pl.gungnir.todo.util.di.useCaseModule
import pl.gungnir.todo.util.di.viewModelModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                viewModelModule,
                useCaseModule,
                repositoryModule
            )
        }
    }
}