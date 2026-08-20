package com.ix3twastaken.music_player

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform