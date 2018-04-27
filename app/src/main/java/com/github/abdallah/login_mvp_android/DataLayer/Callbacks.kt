package com.github.abdallah.login_mvp_android.DataLayer

import com.github.abdallah.login_mvp_android.DataLayer.Models.LoginModel

interface Callbacks {
    interface BaseNetworkCallbacks<SuccessType> {
        fun onSuccess(successType: SuccessType)

        fun onError()
    }

    interface LoginCallbacks : BaseNetworkCallbacks<LoginModel>
}