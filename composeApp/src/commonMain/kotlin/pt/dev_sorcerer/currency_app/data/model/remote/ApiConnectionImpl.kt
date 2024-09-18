package pt.dev_sorcerer.currency_app.data.model.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import pt.dev_sorcerer.currency_app.ApiToken
import pt.dev_sorcerer.currency_app.data.model.ResponseData

class ApiConnectionImpl(
    private val httpClient: HttpClient
) : ApiConnection {
    override suspend fun fetchData(): ResponseData {
        val response : ResponseData = httpClient.get("https://api.currencyapi.com/v3/latest") {
            headers {
                append(HttpHeaders.Accept, "application/json")
                append("apikey", ApiToken.API_KEY)
            }
        }.body()

        return response
    }
}