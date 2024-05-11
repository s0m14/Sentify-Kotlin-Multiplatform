package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.AppealData

class AppealScreen : Screen {

    private lateinit var navigator: Navigator

    @Composable
    override fun Content() {
        HomeScreen().Content()
        AppealScreen()
    }

    @Composable
    fun AppealScreen() {

        navigator = LocalNavigator.currentOrThrow

        var purpose by remember { mutableStateOf("") }
        var targetAudience by remember { mutableStateOf("") }
        var tone by remember { mutableStateOf("") }
        var desiredOutcomes by remember { mutableStateOf("") }


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
        ) {

            OutlinedTextField(
                value = purpose,
                onValueChange = { purpose = it },
                label = { Text(text = "What is the purpose of your message? Have you been treated unfairly? Do you want someone to reconsider a decision they made about you? Do you have any unsaid things?", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp).padding(top = 120.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = targetAudience,
                onValueChange = { targetAudience = it },
                label = { Text(text =  "Who is the intended audience for the message? Provide details such as age, gender, location, interests and any other relevant information", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = desiredOutcomes,
                onValueChange = { desiredOutcomes = it },
                label = { Text(text = "What outcome are you hoping for", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = tone,
                onValueChange = { tone = it },
                label = { Text(text = "Is it formal,informal,friendly,urgent?", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = desiredOutcomes,
                onValueChange = { desiredOutcomes = it },
                label = { Text(text = "State the outcome you want.", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Button(
                onClick = {
                    navigator.push(
                        AppealResultScreen(
                            AppealData(purpose, targetAudience, tone, desiredOutcomes)
                        )
                    )
                },
                modifier = Modifier.width(200.dp).height(100.dp).padding(top = 60.dp).background(
                    Color.Transparent
                )
            ) {
                Text(
                    text = "Submit"
                )
            }
        }
    }
}