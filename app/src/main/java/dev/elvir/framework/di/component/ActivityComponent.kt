package dev.elvir.framework.di.component

import dagger.Component
import dev.elvir.framework.App
import dev.elvir.framework.MainActivity
import dev.elvir.framework.di.module.ActivityModule
import dev.elvir.framework.di.module.AppModule
import dev.elvir.framework.di.scope.PerScreen
import javax.inject.Singleton

@PerScreen
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent{
    fun inject( mainActivity: MainActivity)
}