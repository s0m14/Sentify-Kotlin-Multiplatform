package data

import sentifyandroid.composeapp.generated.resources.Res
import sentifyandroid.composeapp.generated.resources.apologise
import sentifyandroid.composeapp.generated.resources.appealIcon
import sentifyandroid.composeapp.generated.resources.gratitudeIcon
import sentifyandroid.composeapp.generated.resources.loveIcon

data class Icon(val resId : Int)

val icons = listOf(
    Res.drawable.apologise,
    Res.drawable.gratitudeIcon,
    Res.drawable.appealIcon,
    Res.drawable.loveIcon
)
