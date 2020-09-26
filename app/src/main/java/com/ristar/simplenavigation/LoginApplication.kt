package com.ristar.simplenavigation

import android.app.Application
import com.ristar.simplenavigation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LoginApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    appModule,
                )
            )
        }
    }
}