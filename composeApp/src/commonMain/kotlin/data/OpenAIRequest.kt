package data

import kotlinx.serialization.Serializable

@Serializable
data class OpenAIRequest(
    val model: String,
    val messages: List<Message>,
    val temperature : Int
)
