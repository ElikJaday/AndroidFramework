package dev.elvir.presentation.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import dev.elvir.core.di.helper.CoreInjectHelper
import dev.elvir.presentation.di.component.DaggerScreenComponent


abstract class BaseActivity<out T : ViewDataBinding, out V : BaseViewModel> : AppCompatActivity() {
    private lateinit var viewDataBinding: T
    private var baseViewModel: V? = null
    private lateinit var screenComponent: dev.elvir.presentation.di.component.ScreenComponent


    fun getViewDataBinding(): T {
        return viewDataBinding
    }

    fun getScreenComponent(): dev.elvir.presentation.di.component.ScreenComponent {
        return screenComponent
    }

    abstract fun getBaseViewModel(): V

    abstract fun getBindingVariable(): Int


    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        inject()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    abstract fun inject()

    fun performDependencyInjection() {
        screenComponent = DaggerScreenComponent
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(applicationContext))
            .build()
    }

    fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.baseViewModel = if (baseViewModel == null) getBaseViewModel() else baseViewModel
        viewDataBinding.setVariable(getBindingVariable(), baseViewModel)
        viewDataBinding.executePendingBindings()

    }
}