package pt.dev_sorcerer.currency_app.data.model.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class CoinEntity(): RealmObject {
    @PrimaryKey
    var code: String = ""
    var value: Float = 0f

    constructor(code: String, value: Float): this(){
        this.code = code
        this.value = value
    }
}