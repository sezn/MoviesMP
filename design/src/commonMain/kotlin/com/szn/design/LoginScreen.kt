package com.szn.design

import AuthComponent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginScreen(component: AuthComponent) {
    var email = ""
    var password = ""
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Email")
        TextField(value = email, onValueChange = { email = it })

        Text(text = "Password")
        TextField(value = password, onValueChange = { password = it }, visualTransformation = PasswordVisualTransformation())

        Button(onClick = { /* Login logic */ }) {
            Text(text = "Login")
        }
    }
}