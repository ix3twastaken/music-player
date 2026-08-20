package com.ix3twastaken.music_player.ui.components.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.PlaylistPlay
import androidx.compose.material.icons.automirrored.outlined.PlaylistPlay
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ix3twastaken.music_player.ui.screens.LibraryScreen
import com.ix3twastaken.music_player.ui.screens.SettingsScreen
import com.ix3twastaken.music_player.ui.screens.TracklistScreen

val navigationItems = listOf("Настройки", "Библиотека", "Треки")

val selectedIcons = listOf(
    Icons.Filled.Settings,
    Icons.Filled.LibraryMusic,
    Icons.AutoMirrored.Filled.PlaylistPlay
)
val unselectedIcons = listOf(
    Icons.Outlined.Settings,
    Icons.Outlined.LibraryMusic,
    Icons.AutoMirrored.Outlined.PlaylistPlay
)

@Composable
fun BottomNavBar(selectedTab: Int,
                 onTabSelected: (Int) -> Unit) {
    val navigator = LocalNavigator.currentOrThrow

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.secondaryContainer,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedTab == index,
                onClick = {
                    onTabSelected(index)
                    when (index) {
                        0 -> navigator.replace(SettingsScreen())
                        1 -> navigator.replace(LibraryScreen())
                        2 -> navigator.replace(TracklistScreen())
                        else -> println("Invalid destination")
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = if (selectedTab == index) selectedIcons[index] else unselectedIcons[index],
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = item
                    )
                },
                label = { Text(item) }
            )
        }
    }
}


@Composable
fun TopBar(selectedTabName: String, scrollBehavior: TopAppBarScrollBehavior?= null) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        ),
        scrollBehavior = scrollBehavior,
        actions = {
            IconButton(
                onClick = {},
                shapes = IconButtonShapes(CircleShape),
                content = {
                    Icon(
                        modifier = Modifier
                            .size(38.dp),
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Поиск")
                }
            )
        },
        title = {
            Text(
                selectedTabName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    )
}