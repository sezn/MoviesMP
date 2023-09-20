package com.szn.decompose.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.szn.decompose.main.MainComponent
import com.szn.decompose.welcome.AuthComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class Main(val component: MainComponent) : Child()
        class Auth(val component: AuthComponent) : Child()
    }
}
