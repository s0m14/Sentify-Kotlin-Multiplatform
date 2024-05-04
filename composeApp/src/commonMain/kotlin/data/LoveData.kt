package data

import kotlinx.serialization.Serializable

@Serializable
data class LoveData(
    val partnerName : String,
    val goalsAsCouples : String,
    val challenges : String,
    val favoriteMemory : String,
    val from : String
)