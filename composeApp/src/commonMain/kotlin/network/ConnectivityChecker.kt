package network
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ConnectivityChecker {
    private val client = HttpClient()

    suspend fun isInternetAvailable(apiKey: String): Boolean {
        return try {
            val response: HttpResponse = client.get("https://api.openai.com/v1/engines") {
                headers {
                    append(HttpHeaders.Authorization, "Bearer $apiKey")
                }
            }
            response.status == HttpStatusCode.OK

        } catch (e: Exception) {
            false
        }
    }
}