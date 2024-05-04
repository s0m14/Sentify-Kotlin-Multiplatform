package ui

import io.ktor.http.ContentType
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
@Serializable
data class OpenAIRequest(
    val model: String,
    val messages: List<Message>,
    val temperature : Int
)

@Serializable
data class InputData(
    val recipentName : String,
    val reason : String,
    val degreeOfRegret : String,
    val commitmentToChange : String
)
@Serializable
data class Message(
    val role : String,
    val content : String
){
    val isUser : Boolean
        get() = role == "user"
}
@Serializable
data class MessageResponse(
    val message: Message
)
@Serializable
data class OpenAIResponse(
    val choices : List<MessageResponse>
)

@Serializable
data class ChatCompletion(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val choices: List<Choice>,
    val usage: Usage,
    val system_fingerprint: String
)

@Serializable
data class Choice(
    val index: Int,
    val message: Message,
   @Contextual val logprobs: Any?, // Can be null, so use Any?
    val finish_reason: String
)

@Serializable
data class Usage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)

@Serializable
data class LoveData(
    val partnerName : String,
    val goalsAsCouples : String,
    val challenges : String,
    val favoriteMemory : String,
    val from : String
)

@Serializable
data class GratitudeData(
    val gratitudeEntry : String,
    val reflection : String,
    val simplePleasure : String,
    val dailyBlessing : String
)


