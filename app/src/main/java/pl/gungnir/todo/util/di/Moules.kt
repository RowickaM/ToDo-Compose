package pl.gungnir.todo.util.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.gungnir.todo.data.repository.ToDoRepositoryImpl
import pl.gungnir.todo.domain.repository.ToDoRepository
import pl.gungnir.todo.domain.usecase.ChangeTaskStateUseCase
import pl.gungnir.todo.domain.usecase.GetCategoryListUseCase
import pl.gungnir.todo.domain.usecase.GetCategoryUseCase
import pl.gungnir.todo.ui.screen.category.CategoryListViewModel
import pl.gungnir.todo.ui.screen.welcome.WelcomeViewModel

val viewModelModule = module {
    viewModel { WelcomeViewModel(get()) }
    viewModel { CategoryListViewModel(get(), get()) }
}
val useCaseModule = module {
    factory { GetCategoryListUseCase(get()) }
    factory { GetCategoryUseCase(get()) }
    factory { ChangeTaskStateUseCase(get()) }
}
val repositoryModule = module {
    single<ToDoRepository> { ToDoRepositoryImpl() }
}