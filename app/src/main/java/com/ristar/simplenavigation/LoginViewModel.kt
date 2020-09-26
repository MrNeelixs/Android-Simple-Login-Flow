package com.ristar.simplenavigation

import android.content.res.Resources
import com.ristar.simplenavigation.data.AuthRepo
import com.ristar.simplenavigation.utils.LiveEvent

class LoginViewModel(val resources: Resources, val authRepo: AuthRepo): BaseViewModel() {

    val errorLD = LiveEvent<String>()

    fun login(login: String, password: String) {
        val successAuth = authRepo.login(login, password)
        if (successAuth) {
            navigationLD.postValue(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        } else {
            errorLD.value = resources.getString(R.string.auth_error)
        }
    }
}