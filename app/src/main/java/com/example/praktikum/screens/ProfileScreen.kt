package com.example.Praktikum.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.Praktikum.auth.AuthState

@Composable
fun ProfileScreen(navController: NavController) {
    val user = AuthState.registeredUser

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        if (user != null) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Profil Pengguna", fontSize = 24.sp, fontWeight = FontWeight.Bold)

                Divider()

                Text("Nama Lengkap:", fontWeight = FontWeight.SemiBold)
                Text(user.fullName)

                Text("Username:", fontWeight = FontWeight.SemiBold)
                Text(user.username)

                Text("Email:", fontWeight = FontWeight.SemiBold)
                Text(user.email)
            }
        } else {
            Text(
                "Belum login.",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
