package data

import kotlinx.serialization.Serializable

@Serializable
data class OpenAIResponse(
    val choices : List<MessageResponse>
)