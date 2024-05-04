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
import data.GratitudeData


class GratitudeScreen : Screen {

    private lateinit var navigator : Navigator

    @Composable
    override fun Content() {
        HomeScreen().Content()
        ComplimentScreen()
    }

    @Composable
    fun ComplimentScreen() {
        navigator = LocalNavigator.currentOrThrow

        var gratitudeEntry by remember{ mutableStateOf("") }
        var reflection by remember{ mutableStateOf("") }
        var simplePleasure by remember { mutableStateOf("") }
        var dailyBlessing by remember { mutableStateOf("") }

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

            OutlinedTextField(
                value = gratitudeEntry,
                onValueChange = { gratitudeEntry = it },
                label = { Text(text = "For what are you grateful?", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp).padding(top = 120.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = reflection,
                onValueChange = { reflection = it },
                label = { Text(text = "Why are you grateful ?", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = simplePleasure,
                onValueChange = { simplePleasure = it },
                label = { Text(text = "Write down your recent small pleasures", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = dailyBlessing,
                onValueChange = { dailyBlessing = it },
                label = { Text(text = "You blessed to have in your life", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Button(
                onClick = {
                    navigator.push(
                        GratitudeResultScreen(GratitudeData(gratitudeEntry, reflection, simplePleasure, dailyBlessing))
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
