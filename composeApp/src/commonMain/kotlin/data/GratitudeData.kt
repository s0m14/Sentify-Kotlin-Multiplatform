package data

import kotlinx.serialization.Serializable

@Serializable
data class GratitudeData(
    val gratitudeEntry : String,
    val reason : String,
    val tone : String
)