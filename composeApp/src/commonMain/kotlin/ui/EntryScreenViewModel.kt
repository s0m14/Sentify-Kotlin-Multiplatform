package ui


import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import network.ApiKey

class EntryScreenViewModel : ViewModel() {

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

    suspend fun getUiState():Boolean{
        if(isInternetAvailable(ApiKey.API_KEY)){
            return true
        }else{
            return false
        }
    }
}