package dev.elvir.framework

import android.os.Bundle

import android.arch.lifecycle.ViewModelProviders

import dev.elvir.framework.base.BaseActivity
import dev.elvir.framework.databinding.ActivityMainBinding



class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    var factory: ViewModelProviderFactory = ViewModelProviderFactory()
    lateinit var mainViewModel: MainViewModel
    lateinit var activityMainBinding: ActivityMainBinding


    override fun getBindingVariable(): Int {
        return BR._all
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBaseViewModel(): MainViewModel {
        mainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        return mainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActivityComponent().inject(this)
        activityMainBinding  = getViewDataBinding()


    }
}
