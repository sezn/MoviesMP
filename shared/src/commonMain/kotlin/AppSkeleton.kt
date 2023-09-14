import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.szn.design.MoviesTheme
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
//                    TopBar(navController, scope, canPop, showLogout.value, title)
                    Column {  }
            },
            contentColor = MaterialTheme.colorScheme.onBackground,
            content = { padding ->
//                NavigationHost(navController = navController, modifier = Modifier.padding(padding))
            },
            bottomBar = {
                if(showBottomBar.value)
                    BottomNavigationBar(BarItems)
            }
        )
    }
}