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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.ApologizeData


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

        val focusManager = LocalFocusManager.current

        var relationship by remember{ mutableStateOf("") }
        var natureOfTheMistake by remember{ mutableStateOf("") }
        var commitmentToChange by remember { mutableStateOf("") }

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

                OutlinedTextField(
                    value = relationship,
                    onValueChange = { relationship = it },
                    label = { Text(text = "Relationship with recipent.Is it your friend,colleague or family member", fontSize = 20.sp)},
                    modifier = Modifier.width(1200.dp).padding(top = 120.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = natureOfTheMistake,
                    onValueChange = { natureOfTheMistake = it },
                    label = { Text(text = "Describe the mistake that occured.Provide specific details what went wrong", fontSize = 20.sp)},
                    modifier = Modifier.width(1200.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = commitmentToChange,
                    onValueChange = {commitmentToChange = it},
                    label = {Text(text = "Explain what you will do to correct the mistake",fontSize = 20.sp)},
                    modifier = Modifier.width(1200.dp)
                )

                Button(
                    onClick = {navigator.push(ApologizeResultScreen(ApologizeData(relationship,natureOfTheMistake, commitmentToChange)))},
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
