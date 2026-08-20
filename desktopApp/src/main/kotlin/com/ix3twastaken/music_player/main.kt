package com.ix3twastaken.music_player

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Musicplayer",
    ) {
        App()
    }
}