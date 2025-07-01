package com.example.Praktikum.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.Praktikum.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    // State untuk menyimpan teks yang diketik user
    var text by remember { mutableStateOf("") }

    // Box untuk mengatur konten ke tengah layar
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Kolom berisi label, input teks, dan tombol
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Masukkan Nama:") // Label input
            TextField(
                value = text, // Nilai teks dari state
                onValueChange = { text = it }, // Perubahan input disimpan ke state
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp)) // Jarak antar komponen
            Button(onClick = {
                // Navigasi ke halaman Result dengan teks sebagai argumen
                navController.navigate(route = Screen.Result.passText(text))
            }) {
                Text("Submit") // Teks tombol
            }
        }
    }
}


@Preview
@Composable
private fun HomePreview() {

}