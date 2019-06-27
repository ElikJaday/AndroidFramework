package dev.elvir.presentation.ui.login

import android.util.Log
import dev.elvir.presentation.base.BaseViewModel
import javax.inject.Inject


class LoginViewModel @Inject constructor() : BaseViewModel(){
    fun doSomething() =  Log.e("Infoooo",javaClass.name)
}