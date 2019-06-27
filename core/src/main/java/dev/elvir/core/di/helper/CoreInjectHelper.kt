package dev.elvir.core.di.helper

import android.content.Context
import dev.elvir.core.di.component.CoreComponent
import dev.elvir.core.di.provider.CoreComponentProvider


object CoreInjectHelper {
    fun provideCoreComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("The application context you have passed does not implement CoreComponentProvider")
        }
    }
}