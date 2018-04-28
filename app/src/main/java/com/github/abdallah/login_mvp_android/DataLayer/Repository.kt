package com.github.abdallah.login_mvp_android.DataLayer

interface Repository {
    fun login(userEmail: String, password: String, callbacks: Callbacks.LoginCallbacks)
}