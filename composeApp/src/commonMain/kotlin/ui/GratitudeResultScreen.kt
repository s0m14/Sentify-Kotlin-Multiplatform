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
import data.GratitudeData
import data.Message

data class GratitudeResultScreen(val gratitudeData: GratitudeData) : Screen {
    val viewModel = GratitudeViewModel()

    private lateinit var navigator : Navigator

    val prompt = "Make gratitude message. Here is details:" + gratitudeData.gratitudeEntry + "," + gratitudeData.reflection + "," + gratitudeData.dailyBlessing + "," + gratitudeData.simplePleasure
    @Composable
    override fun Content() {
        HomeScreen().Content()
        var answer by remember{ mutableStateOf("") }

        navigator = LocalNavigator.currentOrThrow

        val messages = mutableStateListOf<Message>()

        messages.add(Message("user",prompt))
        LaunchedEffect(Unit){
            viewModel.sendGratitude(message = messages,"sk-proj-7uRYYbBekvLy9fKn8Dq3T3BlbkFJlSkzPVgrIXf6zOh529KL")
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