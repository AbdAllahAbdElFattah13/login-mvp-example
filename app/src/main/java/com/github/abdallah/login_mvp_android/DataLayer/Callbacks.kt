package com.github.abdallah.login_mvp_android.DataLayer

import com.github.abdallah.login_mvp_android.DataLayer.Models.ErrorType
import com.github.abdallah.login_mvp_android.DataLayer.Models.LoginModel

interface Callbacks {
    interface BaseNetworkCallbacks<SuccessType> {
        fun onSuccess(resultModel: SuccessType)

        fun onError(error: ErrorType)
    }

    interface LoginCallbacks : BaseNetworkCallbacks<LoginModel>
}