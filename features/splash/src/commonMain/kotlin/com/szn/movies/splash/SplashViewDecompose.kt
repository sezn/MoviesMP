package com.szn.movies.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.szn.decompose.main.MainComponent
import com.szn.design.MoviesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashViewDecompose(component: MainComponent,
                        modifier: Modifier = Modifier) {
    val TAG = "SplashView"


    MoviesTheme {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = { padding ->
                Splash(component)
            }
        )

    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun Splash(component: MainComponent) {

    val scale = remember {
        Animatable(0f)
    }
    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    FastOutLinearInEasing.transform(1.6f)
                })
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            contentAlignment = Alignment.Center, // Center the image inside the outer Box
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource("movienight.png"),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(320.dp)
                    .scale(scale.value)
                    .clickable {
                        component.onShowWelcomeClicked()
                    }
            )
        }

        Box(
            contentAlignment = Alignment.BottomCenter, // Align text to the bottom center
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Version 1-Decompose",
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp) // Add some padding to separate the text from the bottom edge
            )
        }
    }

    // Launch onShowWelcomeClicked() after 2 seconds of the screen loading
    // TODO: auth stuff..
    LaunchedEffect(key1 = true) {
        delay(2000L)
        component.onShowWelcomeClicked()
    }
}
