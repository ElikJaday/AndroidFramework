package dev.elvir.presentation.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.elvir.core.di.qualifier.ViewModelKey
import dev.elvir.presentation.di.ViewModelFactory
import dev.elvir.presentation.ui.login.LoginViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: LoginViewModel): ViewModel
}
