package ui
import androidx.compose.runtime.mutableStateListOf
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.call.receive
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json



class GratitudeViewModel : ViewModel(){

    private lateinit var response: HttpResponse
    var responseBody : String = ""

    val list = listOf<Message>(Message("user","Arsen"))

    val openAIRequest = OpenAIRequest(model = "gpt-3.5-turbo",list,1)

    val json = Json.encodeToString(openAIRequest)

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }
        defaultRequest {
        }


    }
    @OptIn(InternalAPI::class)
    @kotlinx.serialization.ExperimentalSerializationApi
    suspend fun sendGratitude(message:List<Message>,apiKey: String) {
        try {
            val openAIRequest = OpenAIRequest(model = "gpt-3.5-turbo", messages = message, temperature = 1)

            val json = Json.encodeToString(openAIRequest)

            response = client.request("https://api.openai.com/v1/chat/completions"){
                method = HttpMethod.Post
                header(HttpHeaders.Authorization,"Bearer $apiKey")
                contentType(ContentType.Application.Json)
                body = json
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @OptIn(InternalAPI::class)
    suspend fun getAnswer():String {
        if(response.status.description == "OK"){
            return response.bodyAsText()
        }else{
            return "NO VALUE"
        }
    }

    suspend fun getContent() : String? {
        val json = response.bodyAsText().trimIndent()
        val chatCompletion = Json.decodeFromString(ChatCompletion.serializer(), json)

        val content = chatCompletion.choices.firstOrNull()?.message?.content

        return content
    }
}