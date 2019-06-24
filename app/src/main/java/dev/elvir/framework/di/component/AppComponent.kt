package dev.elvir.framework.di.component

import dagger.Component
import dev.elvir.framework.App
import dev.elvir.framework.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{
    fun inject(app:App)

}