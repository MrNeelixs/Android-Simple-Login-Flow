package com.ristar.simplenavigation

import android.text.format.DateUtils
import androidx.lifecycle.viewModelScope
import com.ristar.simplenavigation.data.AuthRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(val authRepo: AuthRepo) : BaseViewModel() {

    fun checkLogin() {
        viewModelScope.launch {
            delay(3 * DateUtils.SECOND_IN_MILLIS)
            navigationLD.postValue(
                if (authRepo.isAuthorized()) SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                else SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            )
        }
    }
}