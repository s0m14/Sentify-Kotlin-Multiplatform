package data

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val role : String,
    val content : String
)