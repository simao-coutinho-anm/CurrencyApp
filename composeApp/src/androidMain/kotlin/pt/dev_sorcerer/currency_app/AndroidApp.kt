package pt.dev_sorcerer.currency_app

import android.app.Application
import pt.dev_sorcerer.currency_app.data.model.di.startDI

class AndroidApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startDI()
    }
}