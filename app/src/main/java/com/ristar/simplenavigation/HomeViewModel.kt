package com.ristar.simplenavigation

import com.ristar.simplenavigation.data.AuthRepo

class HomeViewModel(private val authRepo: AuthRepo) : BaseViewModel() {

    fun logout() {
        authRepo.logout()
        navigationLD.value = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
    }

}