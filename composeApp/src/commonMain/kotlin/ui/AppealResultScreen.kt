package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.AppealData
import data.Message

data class AppealResultScreen(val appealData: AppealData) : Screen {
    val viewModel = AppealViewModel()

    private lateinit var navigator : Navigator

    val prompt = "Make appeal message. Here is details:" + appealData.subjectOfAppeal + "," + appealData.detailedExplanation + "," + appealData.urgency + "," + appealData.desiredOutcomes + "," + appealData.yourName
    @Composable
    override fun Content() {
        HomeScreen().Content()
        var answer by remember{ mutableStateOf("") }

        navigator = LocalNavigator.currentOrThrow

        val messages = mutableStateListOf<Message>()

        messages.add(Message("user",prompt))
        LaunchedEffect(Unit){
            viewModel.sendAppeal(message = messages,"sk-proj-u080kiFZ4ov0dgsNU9QYT3BlbkFJ1ROx50wwvPtKgutWRFXm")
            answer = viewModel.getContent().toString()
        }

        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = answer,
                enabled = true,
                onValueChange = {answer = it} ,
                label = {
                    Text(text = "Your message", fontSize = 50.sp)
                },
                textStyle = TextStyle(fontSize = 35.sp),
                modifier = Modifier.width(1500.dp).height(300.dp).padding(top = 30.dp))
            Button(
                onClick = {navigator.pop()},
                modifier = Modifier.width(200.dp).height(100.dp).padding(top = 60.dp).background(
                    Color.Transparent)
            ){
                Text(
                    text = "Go to Home Screen"
                )
            }
        }
    }
}