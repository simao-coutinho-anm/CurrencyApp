package pt.dev_sorcerer.currency_app.data.model.di

import com.russhwolf.settings.Settings
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import pt.dev_sorcerer.currency_app.data.model.local.AppPreferences
import pt.dev_sorcerer.currency_app.data.model.local.AppPreferencesImpl
import pt.dev_sorcerer.currency_app.data.model.remote.ApiConnection
import pt.dev_sorcerer.currency_app.data.model.remote.ApiConnectionImpl
import pt.dev_sorcerer.currency_app.presentation.AppViewModel

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
    singleOf(::Settings)
    single<ApiConnection> { ApiConnectionImpl(get()) }
    single<AppPreferences> { AppPreferencesImpl(get()) }
    singleOf(::AppViewModel)


}

fun startDI() {
    startKoin {
        koin.loadModules(listOf(dataModule))
    }
}