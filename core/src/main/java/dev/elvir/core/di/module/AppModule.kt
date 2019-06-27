package dev.elvir.core.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class AppModule(val application: Application) {
    @Singleton
    @Provides
    fun provideApplication(): Application {
        return application
    }
}