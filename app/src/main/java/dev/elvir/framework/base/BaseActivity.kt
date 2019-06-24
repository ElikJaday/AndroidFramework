package dev.elvir.framework.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import dev.elvir.framework.App
import dev.elvir.framework.di.component.ActivityComponent
import dev.elvir.framework.di.component.DaggerActivityComponent

import dev.elvir.framework.di.module.ActivityModule


abstract class BaseActivity<out T : ViewDataBinding, out V : BaseViewModel> : AppCompatActivity() {
    private lateinit var viewDataBinding: T
    private  var baseViewModel: V? = null
    private lateinit var activityComponent: ActivityComponent


     fun getViewDataBinding(): T {
        return viewDataBinding
    }
     fun getActivityComponent(): ActivityComponent {
        return activityComponent
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
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .appComponent((application as App).getAppComponent())
            .build()
    }

    fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.baseViewModel = if (baseViewModel == null) getBaseViewModel() else baseViewModel
        viewDataBinding.setVariable(getBindingVariable(), baseViewModel)
        viewDataBinding.executePendingBindings()

    }
}