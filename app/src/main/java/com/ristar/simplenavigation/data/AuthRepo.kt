package com.ristar.simplenavigation.data

interface AuthRepo {

    fun isAuthorized(): Boolean
    fun login(email: String, password: String): Boolean
    fun logout()

}