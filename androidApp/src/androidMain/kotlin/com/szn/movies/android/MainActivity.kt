package com.szn.movies.android

import AppContent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.arkivanov.decompose.defaultComponentContext
import com.szn.decompose.root.DefaultRootComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = DefaultRootComponent(componentContext = defaultComponentContext())
        println("BuildConfig APP_SECRET: ${BuildConfig.APP_SECRET}")
        println("BuildConfig APPLICATION_ID: ${BuildConfig.APPLICATION_ID}")
        println("BuildConfig TOKEN: ${BuildConfig.TOKEN}")
        println("BuildConfig PLATFORM: ${com.szn.movies.BuildConfig.PLATFORM}")
        println("BuildConfig API_KEY: ${com.szn.movies.BuildConfig.API_KEY}")


        setContent {
            AppContent(component = root)
        }
    }
}