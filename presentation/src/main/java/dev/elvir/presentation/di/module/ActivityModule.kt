package dev.elvir.presentation.di.module

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dev.elvir.presentation.di.scope.PerScreen


@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    @PerScreen
    fun provideActivity(): AppCompatActivity {
        return activity
    }

}