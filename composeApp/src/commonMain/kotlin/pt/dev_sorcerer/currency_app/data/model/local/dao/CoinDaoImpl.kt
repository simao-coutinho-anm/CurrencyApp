package pt.dev_sorcerer.currency_app.data.model.local.dao

import io.realm.kotlin.Realm
import pt.dev_sorcerer.currency_app.data.model.Coin
import pt.dev_sorcerer.currency_app.data.model.local.model.CoinEntity

class CoinDaoImpl @Inject constructor(
    private val realm: Realm
): CoinDao {
    override suspend fun writeData(data: List<CoinEntity>) {
        realm.write {
            for (entity in data) {
                copyToRealm(entity)
            }
        }
    }

    override suspend fun getAllData(): List<Coin> {
        return realm.query(CoinEntity::class).find().map {
            Coin(it.code, it.value)
        }
    }
}

annotation class Inject
