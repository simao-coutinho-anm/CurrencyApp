package pt.dev_sorcerer.currency_app

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import pt.dev_sorcerer.currency_app.data.Coin
import pt.dev_sorcerer.currency_app.data.ResponseData

class ApiConnection {

    companion object {
        private val client = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
        }

        suspend fun greeting(): String {
            val response : ResponseData = client.get("https://api.currencyapi.com/v3/latest") {
                headers {
                    append(HttpHeaders.Accept, "application/json")
                    append("apikey", ApiToken.API_KEY)
                }
            }.body()

            return response.toString()
        }
    }

}