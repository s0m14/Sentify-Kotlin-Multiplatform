package data

import kotlinx.serialization.Serializable

@Serializable
data class ApologizeData(
    val relationshipWithRecipent : String,
    val natureOfTheMistake:String,
    val commitmentToChange : String,
)
