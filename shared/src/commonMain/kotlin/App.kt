import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.szn.decompose.root.RootComponent
import com.szn.design.MoviesTheme
import com.szn.movies.auth.LoginRoute
import com.szn.movies.auth.LoginView
import com.szn.movies.splash.SplashViewDecompose

@Composable
fun AppContent(component: RootComponent,
               modifier: Modifier = Modifier) {

    MoviesTheme {


        Surface(modifier = modifier.fillMaxSize().windowInsetsPadding(WindowInsets.systemBars)) {

            Children(
                stack = component.stack,
                modifier = Modifier.fillMaxSize(),
                animation = stackAnimation(fade() + scale())
            ) {
                when (val instance = it.instance) {
                    is RootComponent.Child.Main -> SplashViewDecompose(component = instance.component)
                    is RootComponent.Child.Auth -> LoginRoute(component = instance.component,
                        /*onSignIn = { email, password ->
                            {
                                println("Login...")
//                            component.onLogin(email, password)
                            }
                        }*/)

                    else -> {
                        throw Exception("Unknown child $instance")
                    }
                }

            }

        }

    }

}