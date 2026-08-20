package com.ix3twastaken.music_player.ui.components.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MediaTitleBlock(
    title: String,
    subtitle: String,
    titleSize: TextUnit,
    subtitleSize: TextUnit = 16.sp
) {
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Text(text = title,
            fontSize = titleSize,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
        Text(text = subtitle,
            fontSize = subtitleSize,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }
}