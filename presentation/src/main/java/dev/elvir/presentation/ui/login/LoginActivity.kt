package dev.elvir.presentation.ui.login

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import dev.elvir.presentation.base.BaseActivity
import dev.elvir.presentation.BR
import dev.elvir.presentation.R
import dev.elvir.presentation.databinding.ActivityLoginBinding
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var activityLoginBinding: ActivityLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun getBaseViewModel(): LoginViewModel {
        return viewModel
    }

    override fun getBindingVariable(): Int {
        return BR.loginViewModel
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_login
    }

    override fun inject() = getScreenComponent().inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = getViewDataBinding()
    }
}
