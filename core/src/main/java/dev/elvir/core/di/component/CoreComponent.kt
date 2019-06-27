package dev.elvir.core.di.component

import android.app.Application
import dagger.Component
import dev.elvir.core.di.module.AppModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface CoreComponent {
    fun inject(application: Application)
}