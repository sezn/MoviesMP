package com.szn.movies.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeView() {
    val TAG = "HomeView"

    Box(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center, // Center the image inside the outer Box
            modifier = Modifier.fillMaxWidth()) {

            Text("Home")

            Image(
                painter = painterResource("movienight.png"),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(320.dp)
            )
        }

        Box(contentAlignment = Alignment.BottomCenter, // Align text to the bottom center
            modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Version 1",
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp) // Add some padding to separate the text from the bottom edge
            )
        }
    }

}