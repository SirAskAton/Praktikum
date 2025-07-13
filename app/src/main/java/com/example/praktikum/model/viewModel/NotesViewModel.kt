package com.example.Praktikum.model.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Praktikum.model.NoteItem
import com.example.Praktikum.service.api.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {
    private val _notes = MutableStateFlow<List<NoteItem>>(emptyList())
    val notes: StateFlow<List<NoteItem>> = _notes

    init {
        getAllNotes()
    }

    private fun getAllNotes() {
        viewModelScope.launch {
            try {
                val response = ApiClient.instance.getAllNotes()
                _notes.value = response.data.notes
                Log.d("NotesViewModel", "Berhasil ambil ${_notes.value.size} notes")
            } catch (e: Exception) {
                Log.e("NotesViewModel", "Gagal mengambil notes: ${e.localizedMessage}")
            }
        }
    }
}
