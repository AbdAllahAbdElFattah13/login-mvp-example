package com.github.abdallah.login_mvp_android.DataLayer

import com.github.abdallah.login_mvp_android.DataLayer.Models.LoginModel
import java.util.*

object DataRepository : Repository {

    //to be used to get a random response to mock the
    //server call success and the server returned result.
    private val mRandom = Random()

    override fun login(callbacks: Callbacks.LoginCallbacks) {

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
            //invoke the onSuccess method, because after all
            //it's a successful network call.
            val mLoginModel = LoginModel(mRandom.nextBoolean())
            callbacks.onSuccess(mLoginModel)
        } else {
            callbacks.onError()
        }
    }
}