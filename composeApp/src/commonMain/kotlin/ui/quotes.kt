package data
import model.Quotes
import sentifyandroid.composeapp.generated.resources.Res
import sentifyandroid.composeapp.generated.resources.apologise
import sentifyandroid.composeapp.generated.resources.complimentIcon
import sentifyandroid.composeapp.generated.resources.condolencesIcon
import sentifyandroid.composeapp.generated.resources.gratitudeIcon
import sentifyandroid.composeapp.generated.resources.loveIcon

val quotes = listOf(
        Quotes("If you have the words, there's always a chance that you'll find the way.","― Seamus Heaney"),
        Quotes("Keep your best wishes, close to your heart and watch what happens","-T.DeLiso"),
        Quotes("It is beautiful to express love and even more beautiful to feel it.","-D.Stojanovic")
    )

    val icons = listOf(
        Res.drawable.apologise,
        Res.drawable.complimentIcon,
        Res.drawable.loveIcon,
        Res.drawable.gratitudeIcon,
        Res.drawable.condolencesIcon
    )
