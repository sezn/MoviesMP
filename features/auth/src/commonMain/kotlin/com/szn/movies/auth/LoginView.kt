package com.szn.movies.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.szn.decompose.welcome.AuthComponent
import com.szn.design.views.RoundedCornersTextField
import com.szn.domain.repo.AuthRepositoryImpl
import com.szn.movies.network.authAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject


@Composable
fun LoginRoute(component: AuthComponent){
    val mail = remember { mutableStateOf("") }

//     val authRepository: AuthRepositoryImpl by inject()
    val authRepository = koinInject<AuthRepositoryImpl>()

    LoginView(login = mail.value,
        onSignIn = { mail, pass ->

        println("LoginRoute onSignIn $mail $pass")
//        component.onSignIn(mail, pass)
            CoroutineScope(Dispatchers.Main).launch {

                val auth = authAPI.auth()
//                val auth = authAPI.authenticate().collect {
//                    println("LoginRoute API onSignIn $it")
//                }
//                val auth = authRepository.auth()
//                val auth = authRepository.authBis()
                println("LoginRoute auth: $auth")
                /*authAPI.authenticate().collect{
                    println("LoginRoute API onSignIn $it")
                }*/


           /*     delay(4000)
                val authB = authRepository.testAuth()
                println("LoginRoute authTest: $authB")*/
            }

    })
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
@Composable
fun LoginView(login: String? = null,
              errorMessage: String? = null,
              onSignIn: (mail: String, password: String) -> Unit,
) {

    var pass by remember { mutableStateOf("") }
    var pseudo by remember { mutableStateOf("") }
    var openDialog = remember { false}
    val title = "Login"
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val (focusRequester) = remember{ FocusRequester.createRefs() }


    Image(painter = painterResource("background.png"),
        contentDescription = "BG",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize(),
        colorFilter = ColorFilter.tint(
            Color(0x1A040722),
            BlendMode.Saturation
        )
    )
    Column(Modifier.padding(24.dp)) {
        Text(text = title,
            style = MaterialTheme.typography.bodyMedium)
        Spacer( Modifier.height(24.dp))
        Text(text = "Nickname")
        RoundedCornersTextField(
            state = pseudo,
            holder = "Gégé",
            onValueChange = { pseudo = it },
            focusRequester = focusRequester
        )

        Spacer(Modifier.height(8.dp))
        Text(text = "Pass")
        RoundedCornersTextField(
            state = pass,
            holder = "Pass",
            onValueChange = { pass = it },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            focusRequester = focusRequester
        ) {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

//            val description = if (passwordVisible) stringResource(id = com.szn.movie.auth.R.string.pass_hide) else stringResource(id = com.szn.movie.auth.R.string.pass_show)
            val description = if (passwordVisible) "Hide" else "Show"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        }

        Spacer( Modifier.height(48.dp))
        Button(onClick = {
            println("Login onLogin $login")
            scope.launch {
                onSignIn(pseudo, pass)
            }
        },
            modifier = Modifier
                .focusRequester(focusRequester)
                .border(0.75.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(4.dp))

        ) {
            Text(text = "Login",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth())
        }

        Spacer(Modifier.height(64.dp))
        Button(onClick = {
            println("Login, onPassClick $login $pseudo")
//            navController.navigate("home")
        },
            modifier = Modifier
                .focusRequester(focusRequester)
                .border(0.75.dp, MaterialTheme.colorScheme.onBackground, RoundedCornerShape(4.dp))
        ){
            Text(text ="Pass",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth())
        }

    }

}

