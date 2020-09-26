package com.ristar.simplenavigation.data

import android.content.SharedPreferences

class DummyAuthRepo(val sharedPreferences: SharedPreferences) : AuthRepo {

    override fun isAuthorized() = sharedPreferences.getBoolean(IS_AUTHORIZED, false)

    override fun login(email: String, password: String): Boolean {
        val isCorrect = email == LOGIN && password == PASSWORD
        sharedPreferences.edit().putBoolean(IS_AUTHORIZED, isCorrect).apply()
        return isCorrect
    }

    override fun logout() {
        sharedPreferences.edit().putBoolean(IS_AUTHORIZED, false).apply()
    }

    companion object {
        const val LOGIN = "admin@admin.ru"
        const val PASSWORD = "1234"
        const val IS_AUTHORIZED = "IS_AUTHORIZED"
    }
}