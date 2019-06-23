package dev.elvir.framework.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dev.elvir.framework.App
import dev.elvir.framework.di.component.AppComponent
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Singleton
    @Provides
    fun provideApplication(): Application {
        return app;
    }
}