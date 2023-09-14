package com.szn.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SplashView() {
    val TAG = "SplashView"

    Box(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center, // Center the image inside the outer Box
            modifier = Modifier.fillMaxWidth()) {
            /*Image(
                painter = painterResource(id = R.drawable.movienight),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(320.dp)
                    .scale(scale.value)
            )*/
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