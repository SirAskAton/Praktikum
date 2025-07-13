package com.example.Praktikum.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.Praktikum.components.NoteCard
import com.example.Praktikum.model.viewModel.NotesViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: NotesViewModel = viewModel()
) {
    val notesState by viewModel.notes.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        if (notesState.isEmpty()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(notesState) { noteItem ->
                    NoteCard(note = noteItem.toNote())
                }
            }
        }
    }
}
