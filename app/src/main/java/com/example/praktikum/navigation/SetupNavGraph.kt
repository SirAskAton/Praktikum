package com.example.Praktikum.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.Praktikum.screens.HomeScreen
import com.example.Praktikum.screens.ProfileScreen
import com.example.Praktikum.screens.ResultScreen
import com.example.Praktikum.screens.LoginScreen
import com.example.Praktikum.screens.RegisterScreen

@Composable
fun SetupNavGraph(navController: NavHostController,
                  modifier: Modifier,
                  startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }


        composable(
            route = Screen.Result.route,
            arguments = listOf(navArgument("text") {
                type = NavType.StringType
            })
        ) {
            ResultScreen(it.arguments?.getString("text").toString(), navController)
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
    }
}
