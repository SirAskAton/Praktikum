package com.example.Praktikum.model

data class Note(
    val id_notes: String,
    val id_user: String,
    val title: String,
    val content: String,
    val created_at: String,
    val updated_at: String,
    val nm_lengkap: String
)

data class NotesResponse(
    val code: Int,
    val message: String,
    val data: NotesData
)

data class NotesData(
    val notes: List<NoteItem>
)

data class NoteItem(
    val id_notes: String,
    val id_user: String,
    val title: String,
    val content: String,
    val created_at: String,
    val updated_at: String,
    val nm_lengkap: String
)
