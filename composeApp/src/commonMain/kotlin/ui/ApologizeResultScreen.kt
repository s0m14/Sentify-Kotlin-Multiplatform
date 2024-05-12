package ui

import ApologizeViewModel
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
import data.ApologizeData
import data.Message
import network.ApiKey
data class ApologizeResultScreen(val apologyData: ApologizeData) : Screen {
    val viewModel = ApologizeViewModel()

    private lateinit var navigator: Navigator

    val prompt = "Make apology message. Here is details:" + apologyData.relationshipWithRecipent + "," + apologyData.natureOfTheMistake + "," + apologyData.commitmentToChange
    @Composable
    override fun Content() {
        HomeScreen().Content()
        var answer by remember{ mutableStateOf("") }

        val messages = mutableStateListOf<Message>()

        navigator = LocalNavigator.currentOrThrow

        messages.add(Message("user",prompt))
        LaunchedEffect(Unit){
            viewModel.sendApology(message = messages,ApiKey.API_KEY)
            answer = viewModel.getContent().toString()
        }

        if(!answer.isEmpty()){
            ResultScreen(answer, navigator)
        }
    }
}