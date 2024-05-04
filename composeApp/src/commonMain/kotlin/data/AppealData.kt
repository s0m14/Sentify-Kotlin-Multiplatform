package data

import kotlinx.serialization.Serializable

@Serializable
data class AppealData(
    val subjectOfAppeal : String,
    val detailedExplanation : String,
    val desiredOutcomes : String,
    val yourName : String,
    val urgency : String
)
