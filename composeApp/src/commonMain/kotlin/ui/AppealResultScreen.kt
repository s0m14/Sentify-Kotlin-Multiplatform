package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.AppealData
import data.Message
import network.ApiKey

data class AppealResultScreen(val appealData: AppealData) : Screen {
    val viewModel = AppealViewModel()

    private lateinit var navigator : Navigator

    val prompt = "Make appeal message. Here is details:" + appealData.purpose + "," + appealData.targetAudience + "," + appealData.tone + "," + appealData.desiredOutcomes
    @Composable
    override fun Content() {
        HomeScreen().Content()
        var answer by remember{ mutableStateOf("") }

        navigator = LocalNavigator.currentOrThrow

        val messages = mutableStateListOf<Message>()

        messages.add(Message("user",prompt))
        LaunchedEffect(Unit){
            viewModel.sendAppeal(message = messages,ApiKey.API_KEY)
            answer = viewModel.getContent().toString()
        }

        if(!answer.isEmpty()){
            ResultScreen(answer, navigator)
        }

    }
}