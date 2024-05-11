package data

import kotlinx.serialization.Serializable

@Serializable
data class LoveData(
    val recipentName : String,
    val relationship : String,
    val shareSpecificQualities : String,
    val favoriteMemory : String
)