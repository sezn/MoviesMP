package main.android.kt

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.szn.design.SplashView
import com.szn.design.navigation.BarItems
import com.szn.design.navigation.BottomNavigationBar


@Preview
@Composable
fun TestPreview() {

    BottomNavigationBar(navBarItems = BarItems)
}


@Preview
@Composable
fun SplashPreview() {

    SplashView()
}