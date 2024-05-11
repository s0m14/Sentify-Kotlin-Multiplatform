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
import data.LoveData

class LoveScreen : Screen {

    private lateinit var navigator: Navigator

    @Composable
    override fun Content() {
        HomeScreen().Content()
        LoveScreen()
    }

    @Composable
    fun LoveScreen() {

        navigator = LocalNavigator.currentOrThrow

        var recipentName by remember { mutableStateOf("") }
        var relationship by remember { mutableStateOf("") }
        var shareSpecificQualities by remember { mutableStateOf("") }
        var favoriteMemory by remember { mutableStateOf("") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
        ) {

            OutlinedTextField(
                value = recipentName,
                onValueChange = { recipentName = it },
                label = { Text(text = "Recipient's name", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp).padding(top = 120.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = relationship,
                onValueChange = { relationship = it },
                label = { Text(text =  "What is your relationship with the recipient? Is it your friend, romantic partner, spouse, relative?", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = shareSpecificQualities,
                onValueChange = { shareSpecificQualities = it },
                label = { Text(text = "Challenges", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = favoriteMemory,
                onValueChange = { favoriteMemory = it },
                label = { Text(text = "Share specific qualities, traits, or actions that you admire", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = favoriteMemory,
                onValueChange = { favoriteMemory = it },
                label = { Text(text = "Memories", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Button(
                onClick = {
                    navigator.push(
                        LoveResultScreen(
                            LoveData(
                                recipentName, relationship, shareSpecificQualities, favoriteMemory
                            )
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