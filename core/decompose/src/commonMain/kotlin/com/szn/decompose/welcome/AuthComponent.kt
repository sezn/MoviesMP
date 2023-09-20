package com.szn.decompose.welcome

import com.arkivanov.decompose.value.Value

interface AuthComponent {

    val model: Value<Model>

    fun onLogin(name: String, pwd: String)
    fun onForgot(name: String)
    fun onBackClicked()

    data class Model(
        val greetingText: String = "Welcome from Decompose!"
    )
}
