package data

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val role : String,
    val content : String
){
    val isUser : Boolean
        get() = role == "user"
}