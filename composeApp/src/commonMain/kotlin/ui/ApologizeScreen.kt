package ui

import ApologizeViewModel
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
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow


class ApologizeScreen : Screen {
    private lateinit var navigator: Navigator
    @Composable
    override fun Content() {
        HomeScreen().Content()
        ApologizeScreen(modifier = Modifier.fillMaxSize())
    }
    @Composable
    fun ApologizeScreen(modifier: Modifier) {

        navigator = LocalNavigator.currentOrThrow

        val viewModel = ApologizeViewModel()

        var recipentName by remember{ mutableStateOf("") }
        var reason by remember{ mutableStateOf("") }
        var degreeOfRegret by remember { mutableStateOf("") }
        var commitmentToChange by remember{ mutableStateOf("") }

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

                OutlinedTextField(
                    value = recipentName,
                    onValueChange = { recipentName = it },
                    label = { Text(text = "Recipent's name", fontSize = 20.sp)},
                    modifier = Modifier.width(1200.dp).padding(top = 120.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = reason,
                    onValueChange = { reason = it },
                    label = { Text(text = "Reason", fontSize = 20.sp)},
                    modifier = Modifier.width(1200.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = degreeOfRegret,
                    onValueChange = {degreeOfRegret = it},
                    label = {Text(text = "Degree of regret",fontSize = 20.sp)},
                    modifier = Modifier.width(1200.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = commitmentToChange,
                    onValueChange = {commitmentToChange = it},
                    label = {Text(text = "Commitment to change",fontSize = 20.sp)},
                    modifier = Modifier.width(1200.dp)
                )

                Button(
                    onClick = {navigator.push(ApologizeResultScreen(InputData(recipentName,reason, degreeOfRegret, commitmentToChange)))},
                    modifier = Modifier.width(200.dp).height(100.dp).padding(top = 60.dp).background(
                        Color.Transparent)
                ){
                    Text(
                        text = "Submit"
                    )
                }
            }
        }
    }
