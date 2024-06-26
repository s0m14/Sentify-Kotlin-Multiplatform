package org.company.app

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import ui.EntryScreen
import ui.TopBar

@Composable
fun App(){
    Scaffold(
        topBar = {TopBar()}
    ){
        Navigator(screen = EntryScreen())
    }
}