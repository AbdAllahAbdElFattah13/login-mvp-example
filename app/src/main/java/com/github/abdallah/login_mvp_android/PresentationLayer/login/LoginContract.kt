package com.github.abdallah.login_mvp_android.PresentationLayer.login

import com.github.abdallah.login_mvp_android.DataLayer.Models.ErrorType
import com.github.abdallah.login_mvp_android.DataLayer.Models.LoginModel
import com.github.abdallah.login_mvp_android.PresentationLayer.BasePresenter
import com.github.abdallah.login_mvp_android.PresentationLayer.BaseView

interface LoginContract {

    interface View : BaseView {
        fun setLoading(loading: Boolean)

        fun showEmailErrorMsg()

        fun handleNetworkError()

        fun handleLoginFail()

        fun handleLoginSuccess()
    }

    interface Presenter : BasePresenter {
        fun handleOnLoginBtnClick(email: String, password: String)

        fun onLoginSuccess(model: LoginModel)

        fun onLoginError(error: ErrorType)
    }

}