package me.lakhtin.firstlesson

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform