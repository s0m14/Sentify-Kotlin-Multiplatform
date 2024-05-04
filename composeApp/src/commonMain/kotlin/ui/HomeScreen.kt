package ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.icons
import model.Quotes
import sentifyandroid.composeapp.generated.resources.Res
import sentifyandroid.composeapp.generated.resources.apologise
import sentifyandroid.composeapp.generated.resources.appealIcon
import sentifyandroid.composeapp.generated.resources.complimentIcon

class HomeScreen : Screen {
    private lateinit var navigator: Navigator

    @Composable
    override fun Content() {
        TopBar()
        HomeScreen(modifier = Modifier.fillMaxSize())
    }

    @Composable
    fun HomeScreen(modifier: Modifier) {
        val quotes = listOf(
            Quotes("If you have the words, there's always a chance that you'll find the way.","― Seamus Heaney"),
            Quotes("Keep your best wishes, close to your heart and watch what happens","-T.DeLiso"),
            Quotes("It is beautiful to express love and even more beautiful to feel it.","-D.Stojanovic")
        )

        val icons = listOf(
            Res.drawable.apologise,
            Res.drawable.complimentIcon,
            Res.drawable.apologise,
            Res.drawable.appealIcon
        )


        navigator = LocalNavigator.currentOrThrow
        val checked = remember { mutableStateOf(false) }

        LazyRow(modifier = Modifier.padding(top = 150.dp)) {
            itemsIndexed(icons) { index,res ->
                IconToggleButton(
                    checked = checked.value,
                    onCheckedChange = {
                        checked.value = it;
                        if(icons[index] == Res.drawable.apologise) navigator.push(ApologizeScreen())
                    },modifier = Modifier.padding(end = 250.dp).width(100.dp).height(100.dp)
                ) {
                    Icon(
                        painter = org.jetbrains.compose.resources.painterResource(res),
                        contentDescription = "Icon",
                        tint = if (checked.value) Color(
                            0xFFEC407A
                        ) else Color(0xFF000000)
                    )
                }
            }
        }
    }
}