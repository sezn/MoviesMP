package com.szn.design.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
@Composable
fun BottomNavigationBar(navBarItems: List<BarItem>) {

//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = backStackEntry?.destination?.route
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        navBarItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(imageVector = item.image,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
               },
                label = {
                    Text(item.title,
                        color = MaterialTheme.colorScheme.onBackground)
                        },
                selected = true /*currentRoute == item.route*/,
                onClick = {
//                    navController.navigate(item.route)
                    selectedItem = index
                }
            )
        }
    }
}

