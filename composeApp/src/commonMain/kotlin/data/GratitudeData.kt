package data

import kotlinx.serialization.Serializable

@Serializable
data class GratitudeData(
    val gratitudeEntry : String,
    val reflection : String,
    val simplePleasure : String,
    val dailyBlessing : String
)