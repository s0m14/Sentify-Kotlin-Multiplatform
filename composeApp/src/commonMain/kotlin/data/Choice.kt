package data

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Choice(
    val index: Int,
    val message: Message,
    @Contextual val logprobs: Any?,
    val finish_reason: String
)
