package com.ristar.simplenavigation.di

import android.content.Context
import android.content.SharedPreferences
import com.ristar.simplenavigation.HomeViewModel
import com.ristar.simplenavigation.LoginViewModel
import com.ristar.simplenavigation.SplashViewModel
import com.ristar.simplenavigation.data.AuthRepo
import com.ristar.simplenavigation.data.DummyAuthRepo
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

const val SHARED_PREFERENCES = "SHARED_PREFERENCES"

val appModule: Module = module {

    single<AuthRepo> {
        DummyAuthRepo(
            sharedPreferences = androidApplication().applicationContext.getSharedPreferences(
                SHARED_PREFERENCES,
                Context.MODE_PRIVATE
            )
        )
    }

    viewModel {
        SplashViewModel(authRepo = get())
    }

    viewModel {
        LoginViewModel(
            resources = androidApplication().applicationContext.resources,
            authRepo = get()
        )
    }

    viewModel {
        HomeViewModel(authRepo = get())
    }
}