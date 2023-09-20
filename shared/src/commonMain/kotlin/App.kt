import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.szn.design.LoginScreen
import com.szn.design.SplashViewDecompose

@Composable
fun AppContent(component: RootComponent,
               modifier: Modifier = Modifier) {

    Surface(modifier = modifier.fillMaxSize().windowInsetsPadding(WindowInsets.systemBars)) {

        Children(
            stack = component.stack,
            modifier = Modifier.fillMaxSize(),
//            animation = stackAnimation(fade() + scale())
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.Main -> SplashViewDecompose(component = instance.component)
//                is RootComponent.Child.Main -> AppSkeleton(/*component = instance.component*/)
                is RootComponent.Child.Welcome -> LoginScreen(component = instance.component)
                else -> {
                    throw Exception("Unknown child $instance")
                }
            }

//        AppSkeleton()
        }

    }

}