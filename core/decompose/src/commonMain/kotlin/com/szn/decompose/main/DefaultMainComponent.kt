package com.szn.decompose.main

import com.arkivanov.decompose.ComponentContext

class DefaultMainComponent(
    componentContext: ComponentContext,
    private val onShowWelcome: () -> Unit,
) : MainComponent, ComponentContext by componentContext {

    override fun onShowWelcomeClicked() {
        onShowWelcome()
    }
}
