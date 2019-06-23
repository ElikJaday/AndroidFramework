package dev.elvir.framework

import android.app.Application
import dev.elvir.framework.di.component.AppComponent
import dev.elvir.framework.di.component.DaggerAppComponent
import dev.elvir.framework.di.module.AppModule

class App:Application(){
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        setUpDagger()
    }

    private fun  setUpDagger(){
         appComponent = DaggerAppComponent.builder()
             .appModule(AppModule(this))
             .build()
        appComponent.inject(this)
    }

    public fun  getAppComponent():AppComponent {
        return appComponent
    }

}