package data

import kotlinx.serialization.Serializable

    @Serializable
    data class ChatCompletion(
        val id: String,
        val `object`: String,
        val created: Long,
        val model: String,
        val choices: List<Choice>,
        val usage: Usage,
        val system_fingerprint: String?
    )

