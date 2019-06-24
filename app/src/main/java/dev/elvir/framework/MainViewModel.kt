package dev.elvir.framework

import android.util.Log
import dev.elvir.framework.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {
    fun doSomething() =  Log.e("Infoooo","Okkkkk")

}