package com.ix3twastaken.music_player.ui.components.player

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PauseCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ix3twastaken.music_player.ui.components.common.MediaTitleBlock

@Composable
fun MiniPlayer(title: String, subtitle: String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .clip(shape = CircleShape)
        .border(width = 1.dp, shape = CircleShape, color = MaterialTheme.colorScheme.outlineVariant)
        .background(MaterialTheme.colorScheme.surfaceContainer)
        .clickable(enabled = true, onClick = {})
    ) {
        Row(modifier = Modifier
            .align(Alignment.CenterStart)) {

            IconButton(onClick = {}, modifier = Modifier
                .padding(start = 12.dp)
                .size(48.dp)) {
                Icon(modifier = Modifier.fillMaxSize(),
                    imageVector = Icons.Filled.PauseCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
            MediaTitleBlock(
                title,
                subtitle,
                16.sp,
                16.sp)
        }
    }
}