package data

import kotlinx.serialization.Serializable

@Serializable
data class AppealData(
    val purpose : String,
    val targetAudience : String,
    val tone : String,
    val desiredOutcomes : String
)
