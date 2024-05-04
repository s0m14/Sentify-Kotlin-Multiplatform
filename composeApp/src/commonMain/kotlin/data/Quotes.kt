package data

import model.Quotes

data class Quotes(val text : String, val author : String)

val quotes = listOf(
    Quotes("If you have the words, there's always a chance that you'll find the way.","― Seamus Heaney"),
    Quotes("Keep your best wishes, close to your heart and watch what happens","-T.DeLiso"),
    Quotes("It is beautiful to express love and even more beautiful to feel it.","-D.Stojanovic")
)