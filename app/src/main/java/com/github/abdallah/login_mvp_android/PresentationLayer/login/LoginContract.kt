package com.github.abdallah.login_mvp_android.PresentationLayer.login

import com.github.abdallah.login_mvp_android.DataLayer.Models.LoginModel
import com.github.abdallah.login_mvp_android.PresentationLayer.BasePresenter
import com.github.abdallah.login_mvp_android.PresentationLayer.BaseView

interface LoginContract {

    interface View : BaseView {
        fun setLoading(loading: Boolean)

        fun showEmailErrorMsg()

        fun handleNetworkError()

        fun handleNetworkSuccess()

        fun handleLoginSuccess()

        fun handleLoginFail()
    }

    interface Presenter : BasePresenter {
        fun handleOnLoginBtnClick(email: String, password: String)

        fun onSuccess(model: LoginModel)

        fun onError()
    }

}