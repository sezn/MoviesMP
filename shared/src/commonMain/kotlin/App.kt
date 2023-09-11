import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.szn.domain.model.fakeMovie
import com.szn.network.model.Favorite
import com.szn.network.moviesAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    val favorite = Favorite(true, 1, "test")
    val movie = fakeMovie

/*    CoroutineScope(Dispatchers.Main).launch {
        val movies = moviesAPI.getMovies()
    }*/

    MaterialTheme {
        var greetingText by remember { mutableStateOf(movie.title) }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(movie.description)
            Button(onClick = {
                greetingText = "Hello, ${getPlatformName()}"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null
                )
            }
        }
    }
}


expect fun getPlatformName(): String