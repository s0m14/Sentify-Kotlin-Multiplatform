import data.ChatCompletion
import data.Message
import data.OpenAIRequest
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.client.engine.cio.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ApologizeViewModel : ViewModel(){

    private lateinit var response: HttpResponse

    var content : String? = null

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }

    }

    @OptIn(InternalAPI::class)
    @kotlinx.serialization.ExperimentalSerializationApi
    suspend fun sendApology(message:List<Message>,apiKey: String) {
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
    suspend fun getContent() : String? {
        val json = response.bodyAsText().trimIndent()
        val chatCompletion = Json.decodeFromString(ChatCompletion.serializer(), json)

        content = chatCompletion.choices.firstOrNull()?.message?.content

        return content
    }
}