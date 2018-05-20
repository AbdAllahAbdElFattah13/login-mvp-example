package com.github.abdallah.login_mvp_android.DataLayer

import android.os.Handler
import com.github.abdallah.login_mvp_android.DataLayer.Models.ErrorType
import com.github.abdallah.login_mvp_android.DataLayer.Models.LoginModel
import java.util.*
import java.util.regex.Pattern

object DataRepository : Repository {

    //to be used to get a random response to mock the
    //server call success and the server returned result.
    private val mRandom = Random()

    private val SERVICE_LATENCY_IN_MILLIS = 5000L

    private fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    override fun login(userEmail: String, password: String, callbacks: Callbacks.LoginCallbacks) {

        //if it's not valid email, no need to simulate network call.
        if (!isEmailValid(email = userEmail)) {
            callbacks.onError(ErrorType.InvalidEmail)
            return
        }

        // Simulate network by delaying the execution.
        Handler().postDelayed({

            //so we have 2 booleans,
            //the first one is being used as a mock up for the
            //server call. (i.e its true value should be considered
            //as if the network request returned 200 code.)
            val isCallToServerSuccessful = mRandom.nextBoolean()
            if (isCallToServerSuccessful) {

                //and the second one is being used as a mock up
                //for the credentials validation. (i.e is user name and
                //and password is correct?)

                //PS: even if the returned result is false, we should
                //invoke the onLoginSuccess method, because after all
                //it's a successful network call.
                val mLoginModel = LoginModel(mRandom.nextBoolean())
                callbacks.onSuccess(mLoginModel)
            } else {
                callbacks.onError(ErrorType.NetworkConnectionError)
            }
        }, SERVICE_LATENCY_IN_MILLIS)
    }
}