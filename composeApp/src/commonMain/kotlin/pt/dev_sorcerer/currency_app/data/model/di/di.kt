package pt.dev_sorcerer.currency_app.data.model.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.module
import pt.dev_sorcerer.currency_app.data.model.local.AppPreferences
import pt.dev_sorcerer.currency_app.data.model.local.AppPreferencesImpl
import pt.dev_sorcerer.currency_app.data.model.remote.ApiConnection
import pt.dev_sorcerer.currency_app.data.model.remote.ApiConnectionImpl

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }
    single<ApiConnection> { ApiConnectionImpl(get()) }
    single<AppPreferences> { AppPreferencesImpl(get()) }
}

fun startDI() {
    startKoin {
        koin.loadModules(listOf(dataModule))
    }
}