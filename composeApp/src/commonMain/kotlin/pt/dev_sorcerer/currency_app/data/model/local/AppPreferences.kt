package pt.dev_sorcerer.currency_app.data.model.local

interface AppPreferences {
    fun getLastUpdatedDate(): Long
    fun getFormatedLastUpdatedDate(): String
    fun setLastUpdatedDate(date: String)
    fun isGreaterThanOneDay(): Boolean
}