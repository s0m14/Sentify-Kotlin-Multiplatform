package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.stringResource

import sentifyandroid.composeapp.generated.resources.Res
import sentifyandroid.composeapp.generated.resources.logo
import sentifyandroid.composeapp.generated.resources.top_bar_description

@Composable
fun TopBar(){
    Row(modifier = Modifier.fillMaxWidth().height(120.dp)){
        Image(
            painter = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.width(120.dp).height(120.dp)
        )

        Text(
            text = stringResource(Res.string.top_bar_description),
            fontSize = 80.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}