package com.example.myapplicationapp.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationapp.viewmodel.ProfileViewModel

private val BabyPink = Color(0xFFFFE4EC)
private val DarkPink = Color(0xFFF06292)

private val DarkBackground = Color(0xFF2A1A21)
private val DarkSurface = Color(0xFF3B2630)

@Composable
fun ProfileApp(
    vm: ProfileViewModel = viewModel { ProfileViewModel() }
) {
    val state by vm.uiState.collectAsState()
    val dark = state.isDarkMode

    val background by animateColorAsState(
        targetValue = if (dark) DarkBackground else BabyPink,
        animationSpec = tween(400)
    )
    val surface by animateColorAsState(
        targetValue = if (dark) DarkSurface else Color.White,
        animationSpec = tween(400)
    )
    val onSurface by animateColorAsState(
        targetValue = if (dark) Color.White else Color(0xFF1C1B1F),
        animationSpec = tween(400)
    )
    val subtle by animateColorAsState(
        targetValue = if (dark) Color(0xFFD0C4C9) else Color.Gray,
        animationSpec = tween(400)
    )

    val colorScheme = (if (dark) darkColorScheme() else lightColorScheme()).copy(
        primary = DarkPink,
        onPrimary = Color.White,
        background = background,
        onBackground = onSurface,
        surface = surface,
        onSurface = onSurface,
        onSurfaceVariant = subtle
    )

    MaterialTheme(colorScheme = colorScheme) {
        Surface(color = background, contentColor = onSurface) {
            ProfileScreen(vm)
        }
    }
}

