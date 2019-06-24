package dev.elvir.framework.di.component

import dagger.Component
import dev.elvir.framework.MainActivity
import dev.elvir.framework.di.module.ActivityModule
import dev.elvir.framework.di.module.ViewModelModule
import dev.elvir.framework.di.scope.PerScreen

@PerScreen
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class,ViewModelModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}