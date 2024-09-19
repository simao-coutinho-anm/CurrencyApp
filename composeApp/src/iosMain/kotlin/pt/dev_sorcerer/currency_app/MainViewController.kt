package pt.dev_sorcerer.currency_app

import androidx.compose.ui.window.ComposeUIViewController
import pt.dev_sorcerer.currency_app.data.model.di.startDI

fun MainViewController()  {
    startDI()

    ComposeUIViewController { App() }
}