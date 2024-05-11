package ui

import androidx.compose.animation.core.EaseInOutCirc
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.quotes
import network.ConnectivityChecker
import org.jetbrains.compose.resources.painterResource
import sentifyandroid.composeapp.generated.resources.Res
import sentifyandroid.composeapp.generated.resources.logo

class EntryScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = EntryScreenViewModel()
        EntryScreen(viewModel)
        LaunchedEffect(Unit) {
            if (viewModel.getUiState()) {
                navigator.push(HomeScreen())
            }else{
            }
        }
    }

    @Composable
    fun EntryScreen(viewModel: EntryScreenViewModel) {
        var isInternetAvailable by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            val connectivityChecker = ConnectivityChecker()
            val apiKey = "sk-proj-u080kiFZ4ov0dgsNU9QYT3BlbkFJ1ROx50wwvPtKgutWRFXm"
            isInternetAvailable = connectivityChecker.isInternetAvailable(apiKey)
        }

        val infinteTransition = rememberInfiniteTransition()

        val angle by infinteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                tween(900, easing = EaseInOutCirc),
                RepeatMode.Restart
            )
        )

        val quotes = remember { quotes }

        val randomQuote = remember { quotes.random() }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.width(500.dp).height(500.dp).rotate(angle)
            )

            Text(
                text = randomQuote.text,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = randomQuote.author,
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(top = 10.dp, start = 400.dp)
            )
        }
    }
}