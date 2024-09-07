package pt.dev_sorcerer.currency_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform