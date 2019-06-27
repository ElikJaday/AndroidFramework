package dev.elvir.presentation.di.component

import dagger.Component
import dev.elvir.core.di.component.CoreComponent
import dev.elvir.presentation.di.scope.PerScreen
import dev.elvir.presentation.di.module.ActivityModule
import dev.elvir.presentation.di.module.ViewModelModule
import dev.elvir.presentation.ui.login.LoginActivity

@PerScreen
@Component(dependencies = [CoreComponent::class], modules = [ActivityModule::class, ViewModelModule::class])
interface ScreenComponent {
    fun inject(loginActivity: LoginActivity)
}