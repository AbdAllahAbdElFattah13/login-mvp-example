package com.github.abdallah.login_mvp_android.DataLayer

interface Repository {
    fun login(callbacks: Callbacks.LoginCallbacks)
}