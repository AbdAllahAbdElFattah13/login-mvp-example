package com.github.abdallah.login_mvp_android.PresentationLayer.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.github.abdallah.login_mvp_android.DataLayer.DataRepository
import com.github.abdallah.login_mvp_android.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private var mLoading = false
    private val mPresenter = LoginPresenter(DataRepository, this)

    private fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    override fun setLoading(loading: Boolean) {
        if (mLoading == loading) return

        var visibility = View.GONE
        if (loading) visibility = View.VISIBLE
        progressBar.visibility = visibility
        mLoading = loading
    }

    override fun showEmailErrorMsg() {
        showToast("Please write a correct Email")
    }

    override fun handleNetworkError() {
        showToast("Please check your network")
    }

    override fun handleLoginFail() {
        showToast("Login fail")
    }

    override fun handleLoginSuccess() {
        showToast("Login success")
    }

    fun onLoginBtnClick(v:View){
        mPresenter.handleOnLoginBtnClick(email = et_email.text.toString(), password = et_password.text.toString())
    }
}
