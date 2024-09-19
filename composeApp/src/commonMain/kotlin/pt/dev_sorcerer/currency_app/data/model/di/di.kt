package pt.dev_sorcerer.currency_app.data.model.di

import com.russhwolf.settings.Settings
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import pt.dev_sorcerer.currency_app.data.model.local.AppPreferences
import pt.dev_sorcerer.currency_app.data.model.local.AppPreferencesImpl
import pt.dev_sorcerer.currency_app.data.model.local.dao.CoinDao
import pt.dev_sorcerer.currency_app.data.model.local.dao.CoinDaoImpl
import pt.dev_sorcerer.currency_app.data.model.local.model.CoinEntity
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

    single {
        val realmConfig = RealmConfiguration.create(
            schema = setOf(
                CoinEntity::class,
            ),
        )
        Realm.open(realmConfig)
    }

    singleOf(::Settings)
    single<ApiConnection> { ApiConnectionImpl(get()) }
    single<AppPreferences> { AppPreferencesImpl(get()) }
    single<CoinDao> { CoinDaoImpl(get()) }
    singleOf(::AppViewModel)


}

fun startDI() {
    startKoin {
        koin.loadModules(listOf(dataModule))
    }
}