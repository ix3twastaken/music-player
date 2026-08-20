package com.ix3twastaken.music_player.ui.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.ix3twastaken.music_player.ui.screens.LibraryScreen
import com.ix3twastaken.music_player.ui.screens.SettingsScreen
import com.ix3twastaken.music_player.ui.screens.TracklistScreen

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
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        modifier = Modifier.padding(top = 8.dp),
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(
            modifier = Modifier.size(36.dp),
            imageVector = if (tabNavigator.current.key == tab.key) selectedIcons[tab.options.index.toInt()] else unselectedIcons[tab.options.index.toInt()],
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = tab.options.title
        ) },
        label = { Text(tab.options.title) }
    )
}

@Composable
fun BottomNavBar() {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.secondaryContainer,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        TabNavigationItem(SettingsScreen)
        TabNavigationItem(LibraryScreen)
        TabNavigationItem(TracklistScreen)
    }
}

@Composable
fun TopBar(title: String, scrollBehavior: TopAppBarScrollBehavior?= null) {
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
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    )
}