
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.szn.design.MoviesTheme
import com.szn.design.SplashView
import com.szn.design.navigation.BarItems
import com.szn.design.navigation.BottomNavigationBar

@Composable
fun AppSkeleton() {

    val showTopBar = remember { mutableStateOf(false) }
    val showBottomBar = remember { mutableStateOf(false) }

    MoviesTheme {
        Scaffold(
            modifier = Modifier.testTag("MoviesApp"),
            topBar = {
                if(showTopBar.value)
                    TopBar("title")
            },
            contentColor = MaterialTheme.colorScheme.onBackground,
            content = { padding ->
                      SplashView()
            },
            bottomBar = {
                if(showBottomBar.value)
                    BottomNavigationBar(BarItems)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    TopAppBar(
        title = {
            Text(title)
        }
    )
}
