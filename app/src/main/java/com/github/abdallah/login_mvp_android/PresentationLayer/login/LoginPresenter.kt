package com.github.abdallah.login_mvp_android.PresentationLayer.login

import com.github.abdallah.login_mvp_android.DataLayer.Callbacks
import com.github.abdallah.login_mvp_android.DataLayer.Models.ErrorType
import com.github.abdallah.login_mvp_android.DataLayer.Models.LoginModel
import com.github.abdallah.login_mvp_android.DataLayer.Repository

class LoginPresenter(repository: Repository, view: LoginContract.View) : LoginContract.Presenter {

    private val mView = view
    private val mRepository = repository

    override fun handleOnLoginBtnClick(email: String, password: String) {
        mView.setLoading(true)
        mRepository.login(email, password, object : Callbacks.LoginCallbacks {
            override fun onSuccess(resultModel: LoginModel) {
                LoginPresenter@ onLoginSuccess(resultModel)
            }

            override fun onError(error: ErrorType) {
                LoginPresenter@ onLoginError(error)
            }
        })
    }

    override fun onLoginSuccess(model: LoginModel) {
        mView.setLoading(false)
        if (model.result) mView.handleLoginSuccess()
        else mView.handleLoginFail()
    }

    override fun onLoginError(error: ErrorType) {
        mView.setLoading(false)
        when (error) {
            ErrorType.NetworkConnectionError -> mView.handleNetworkError()
            ErrorType.InvalidEmail -> mView.showEmailErrorMsg()
        }
    }
}