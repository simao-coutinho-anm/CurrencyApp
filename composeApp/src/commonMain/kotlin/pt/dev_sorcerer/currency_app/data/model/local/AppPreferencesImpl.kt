package pt.dev_sorcerer.currency_app.data.model.local

import com.russhwolf.settings.Settings
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class AppPreferencesImpl(
    private val settings: Settings
) : AppPreferences {
    override fun getLastUpdatedDate() =
        settings.getLong("lastUpdatedDate", -1)


    override fun setLastUpdatedDate(date: String) {
        val value = Instant.parse(date).toEpochMilliseconds()

        settings.putLong("lastUpdatedDate", value)
    }

    override fun isGreaterThanOneDay(): Boolean {
        val lastUpdatedDate = settings.getLong("lastUpdatedDate", -1)
        val now = Clock.System.now().toEpochMilliseconds()
        val difference = now - lastUpdatedDate
        return difference > (1000 * 60 * 60 * 24)
    }
}