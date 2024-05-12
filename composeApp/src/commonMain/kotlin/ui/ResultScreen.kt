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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun ResultScreen(answer: String, navigator: Navigator) {

    var answer by remember { mutableStateOf(answer) }

    val focusManager = LocalFocusManager.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = answer,
            enabled = true,
            onValueChange = { answer = it },
            label = {
                Text(text = "Your message will be displayed here!", fontSize = 50.sp)
            },
            textStyle = TextStyle(fontSize = 35.sp),
            modifier = Modifier.width(1500.dp).height(300.dp).padding(top = 50.dp)
                .onPreviewKeyEvent {
                    when {
                        KeyEventType.KeyUp == it.type && Key.Tab == it.key -> {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        }

                        else -> false
                    }
                })
        Button(
            onClick = { navigator.pop() },
            modifier = Modifier.width(200.dp).height(100.dp).padding(top = 60.dp).background(
                Color.Transparent
            ).onPreviewKeyEvent {
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
                text = "Go home"
            )
        }
    }
}