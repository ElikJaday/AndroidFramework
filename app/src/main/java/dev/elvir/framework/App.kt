package dev.elvir.framework

import android.app.Application
import dev.elvir.core.di.component.CoreComponent
import dev.elvir.core.di.component.DaggerCoreComponent
import dev.elvir.core.di.module.AppModule
import dev.elvir.core.di.provider.CoreComponentProvider

class App : Application(), CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent


    override fun onCreate() {
        super.onCreate()
        setUpDagger()
    }

    private fun setUpDagger() {
        coreComponent = DaggerCoreComponent.builder()
            .appModule(AppModule(this))
            .build()
        coreComponent.inject(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }

}