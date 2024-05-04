package data

import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
    val message: Message
)