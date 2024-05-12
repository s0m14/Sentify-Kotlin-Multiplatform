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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalFocusManager
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

        val focusManager = LocalFocusManager.current

        var gratitudeEntry by remember{ mutableStateOf("") }
        var reason by remember{ mutableStateOf("") }
        var tone by remember { mutableStateOf("") }

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

            OutlinedTextField(
                value = gratitudeEntry,
                onValueChange = { gratitudeEntry = it },
                label = { Text(text = "Who is your recipient? It can be absolutely anyone, even you!", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp).padding(top = 160.dp).onPreviewKeyEvent {
                    when {
                        KeyEventType.KeyUp == it.type && Key.Tab == it.key -> {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        }

                        else -> false
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = reason,
                onValueChange = { reason = it },
                label = { Text(text = "Reason for gratitude.Is it for a specific occasion or simply a spontaneous expression of thanks?", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp).onPreviewKeyEvent {
                    when {
                        KeyEventType.KeyUp == it.type && Key.Tab == it.key -> {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        }

                        else -> false
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = tone,
                onValueChange = { tone = it },
                label = { Text(text = "Do you want it to be warm and heartfelt, casual and friendly, or formal and respectful?", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp).onPreviewKeyEvent {
                    when {
                        KeyEventType.KeyUp == it.type && Key.Tab == it.key -> {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        }

                        else -> false
                    }
                }
            )

            Button(
                onClick = {
                    navigator.push(
                        GratitudeResultScreen(GratitudeData(gratitudeEntry,reason, tone))
                    )
                },
                modifier = Modifier.width(200.dp).height(100.dp).padding(top = 60.dp).background(
                    Color.Transparent).onPreviewKeyEvent {
                    when {
                        KeyEventType.KeyUp == it.type && Key.Tab == it.key -> {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        }

                        else -> false
                    }
                })
             {
                Text(
                    text = "Submit"
                )
            }
        }
    }
}
