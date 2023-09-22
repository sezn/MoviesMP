package com.szn.movies

import android.app.Application
import com.szn.domain.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MoviesApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
//            androidContext(this@MoviesApp)
            androidLogger()
            modules(listOf(
//                commonModule
                authModule
            ))
        }

    }
}