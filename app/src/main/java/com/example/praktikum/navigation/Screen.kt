package com.example.Praktikum.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Result : Screen("result/{text}")
    object Notes : Screen("notes")


    fun passText(text: String): String {
        return "result/$text"
    }

}
