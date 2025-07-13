package com.example.Praktikum.model.request

data class RegisterRequest (
    val nm_lengkap: String,
    val email: String,
    val username: String,
    val password: String
)