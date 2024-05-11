package ui

import ApologizeViewModel
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
import data.ApologizeData
import data.Message
import org.jetbrains.compose.resources.stringResource
import sentifyandroid.composeapp.generated.resources.Res
import sentifyandroid.composeapp.generated.resources.created_message
import sentifyandroid.composeapp.generated.resources.go_home_button


data class ApologizeResultScreen(val inputData: ApologizeData) : Screen {
    val viewModel = ApologizeViewModel()

    private lateinit var navigator: Navigator

    val prompt = "Make apology message. Here is details:" + inputData.recipentName + "," + inputData.reason + "," + inputData.degreeOfRegret + "," + inputData.commitmentToChange
    @Composable
    override fun Content() {
        HomeScreen().Content()
        var answer by remember{ mutableStateOf("") }

        val messages = mutableStateListOf<Message>()

        navigator = LocalNavigator.currentOrThrow

        messages.add(Message("user",prompt))
        LaunchedEffect(Unit){
            viewModel.sendApology(message = messages,"sk-proj-u080kiFZ4ov0dgsNU9QYT3BlbkFJ1ROx50wwvPtKgutWRFXm")
            answer = viewModel.getContent().toString()
        }

        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = answer,
                enabled = true,
                onValueChange = {answer = it} ,
                label = {
                    Text(text = stringResource(Res.string.created_message), fontSize = 50.sp)
                },
                textStyle = TextStyle(fontSize = 35.sp),
                modifier = Modifier.width(1500.dp).height(300.dp).padding(top = 30.dp))

            Button(
                onClick = {navigator.pop()},
                modifier = Modifier.width(200.dp).height(100.dp).padding(top = 60.dp).background(
                    Color.Transparent)
            ){
                Text(
                    text = stringResource(Res.string.go_home_button)
                )
            }
        }
    }
}