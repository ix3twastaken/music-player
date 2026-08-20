package com.ix3twastaken.music_player

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import com.ix3twastaken.music_player.ui.components.navigation.BottomNavBar
import com.ix3twastaken.music_player.ui.components.navigation.TopBar
import com.ix3twastaken.music_player.ui.components.navigation.navigationItems
import com.ix3twastaken.music_player.ui.components.player.MiniPlayer
import com.ix3twastaken.music_player.ui.screens.LibraryScreen
import com.ix3twastaken.music_player.ui.screens.SettingsScreen
import com.ix3twastaken.music_player.ui.screens.TracklistScreen


@Composable
@Preview
fun App() {
    var selectedTab by remember { mutableIntStateOf(1) }

    val screens = listOf(
        SettingsScreen(),
        LibraryScreen(),
        TracklistScreen()
    )

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = rememberTopAppBarState(), snapAnimationSpec = spring(
        dampingRatio = Spring.DampingRatioNoBouncy,
        stiffness = Spring.StiffnessLow
    ))
    AppTheme {
        Navigator(screens[selectedTab]) { navigator ->
            Scaffold(
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = { TopBar(navigationItems[selectedTab], scrollBehavior) },
                bottomBar = {
                    BottomNavBar(selectedTab = selectedTab, onTabSelected = { newTab -> selectedTab = newTab})
                            },
                content = { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        FadeTransition(navigator)

                        if (selectedTab != 0) {
                            // container for mini-player
                            Box(modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .widthIn(
                                    min = 200.dp,
                                    max = 600.dp)
                                .fillMaxWidth()
                                .height(86.dp)
                                .padding(vertical = 12.dp, horizontal = 16.dp)) {
                                MiniPlayer("Непрерывный суицид", "Гражданская оборона")
                            }
                        }
                    }
                }
            )
        }
    }
}












