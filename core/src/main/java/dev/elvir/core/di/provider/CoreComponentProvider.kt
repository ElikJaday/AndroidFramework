package dev.elvir.core.di.provider

import dev.elvir.core.di.component.CoreComponent

interface CoreComponentProvider {
    fun provideCoreComponent(): CoreComponent
}