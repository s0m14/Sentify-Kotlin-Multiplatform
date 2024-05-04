package data

import kotlinx.serialization.Serializable

@Serializable
data class ApologizeData(
    val recipentName : String,
    val reason : String,
    val degreeOfRegret : String,
    val commitmentToChange : String
)
