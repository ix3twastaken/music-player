package com.ix3twastaken.music_player.ui.components.library

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ix3twastaken.music_player.ui.components.common.MediaTitleBlock


@Composable
fun AddPlaylist() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
        .clickable(enabled = true, onClick = {})) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Surface(modifier = Modifier.size(64.dp),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.tertiary){
                Icon(modifier = Modifier.requiredSize(32.dp),
                    imageVector = Icons.Rounded.Add,
                    tint = MaterialTheme.colorScheme.onTertiary,
                    contentDescription = null)
            }

            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(text = "Создать плейлист",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}

@Composable
fun Playlist(title: String, subtitle: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
        .clickable(enabled = true, onClick = {})) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Surface(modifier = Modifier.size(64.dp),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.tertiary){
                Icon(modifier = Modifier.requiredSize(32.dp),
                    imageVector = Icons.Filled.MusicNote,
                    tint = MaterialTheme.colorScheme.onTertiary,
                    contentDescription = null)
            }
            MediaTitleBlock(title, subtitle, 18.sp)
        }
    }
}


@Composable
fun Track(title: String, subtitle: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
        .clickable(enabled = true, onClick = {})) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Surface(modifier = Modifier.size(52.dp),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.tertiary){
                Icon(modifier = Modifier.requiredSize(28.dp),
                    imageVector = Icons.Filled.MusicNote,
                    tint = MaterialTheme.colorScheme.onTertiary,
                    contentDescription = null)
            }
            MediaTitleBlock(title, subtitle, 18.sp)
        }
    }
}
