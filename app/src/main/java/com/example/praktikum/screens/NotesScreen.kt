package com.example.Praktikum.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Praktikum.components.NoteCard
import com.example.Praktikum.model.Note
import com.example.Praktikum.model.NoteItem
import com.example.Praktikum.model.viewModel.NotesViewModel

// Konversi NoteItem → Note
fun NoteItem.toNote(): Note {
    return Note(
        id_notes = id_notes,
        id_user = id_user,
        title = title,
        content = content,
        created_at = created_at,
        updated_at = updated_at,
        nm_lengkap = nm_lengkap
    )
}

@Composable
fun NotesScreen(viewModel: NotesViewModel = viewModel()) {
    val notes by viewModel.notes.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Daftar Catatan",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(notes) { noteItem ->
                NoteCard(note = noteItem.toNote())
            }
        }
    }
}
