package com.szn.design.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String? = null
)

val BarItems = listOf(
    BarItem(
        title = "Home",
        image = Icons.Filled.Home,
//        route = NavRoutes.Home.route
    ),
    BarItem(
        title = "Account",
        image = Icons.Filled.AccountCircle,
//        route = NavRoutes.Account.route
    )
)