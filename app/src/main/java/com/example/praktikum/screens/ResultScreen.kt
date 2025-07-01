package com.example.Praktikum.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.Praktikum.navigation.Screen

@Composable
fun ResultScreen (name:String,navController: NavController) {
    Box(
        modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ){
        Column (modifier = Modifier.padding(16.dp)){
            Text(
                text = "Hallo,$name!",
                style = MaterialTheme.typography.headlineMedium
            )

            Button(onClick =  {
                navController.navigate(route = Screen.Home.route)
            }){
                Text("Kembali")
            }
        }

    }
}