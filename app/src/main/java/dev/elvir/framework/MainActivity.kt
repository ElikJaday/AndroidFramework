package dev.elvir.framework

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.elvir.framework.base.BaseActivity
import dev.elvir.framework.databinding.ActivityMainBinding
import dev.elvir.framework.di.component.ActivityComponent
import dev.elvir.framework.di.component.DaggerActivityComponent
import dev.elvir.framework.di.module.ActivityModule
import javax.inject.Inject



class MainActivity: BaseActivity<ActivityMainBinding,MainViewModel>(){


    @Inject
     lateinit var viewModelFactory: ViewModelProvider.Factory
     lateinit var activityMainBinding: ActivityMainBinding


        private val viewModel: MainViewModel by lazy {
           ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun inject() {
        getActivityComponent().inject(this)
    }
    override fun getBaseViewModel(): MainViewModel {

         return viewModel
    }

    override fun getBindingVariable(): Int {
      return BR.mainViewModel
    }

    override fun getLayoutId(): Int {
         return R.layout.activity_main
     }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         activityMainBinding  = getViewDataBinding()

    }

}