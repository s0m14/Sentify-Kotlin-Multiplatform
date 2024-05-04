package ui

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class LoveViewModel : ViewModel(){

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

        }
        @OptIn(InternalAPI::class)
        @kotlinx.serialization.ExperimentalSerializationApi
        suspend fun sendLove(message:List<Message>,apiKey: String) {
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