package com.example.praktikum

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.Praktikum.components.BottomBar
import com.example.Praktikum.navigation.Screen
import com.example.Praktikum.navigation.SetupNavGraph
import androidx.compose.runtime.getValue
import kotlin.collections.contains
import com.example.Praktikum.auth.AuthState

@Composable
fun MyApp(navController: NavHostController) {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route
    val showBottomBar = listOf(Screen.Home.route, Screen.Profile.route).contains(currentRoute)

    // Tentukan start destination berdasarkan login
    val startDestination = if (AuthState.registeredUser != null) {
        Screen.Home.route
    } else {
        Screen.Login.route
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = {
                if (showBottomBar) {
                    BottomBar(
                        navController = navController,
                        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
                    )
                }
            }
        ) { contentPadding ->
            SetupNavGraph(
                navController = navController,
                modifier = Modifier.padding(contentPadding),
                startDestination = startDestination // 🔥 ini penting
            )
        }
    }
}
