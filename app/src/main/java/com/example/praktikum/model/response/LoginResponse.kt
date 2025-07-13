package com.example.Praktikum.model.response

data class LoginResponse (
    val code: Int,
    val message: String,
    val data: LoginData?,
    val token: String?
)

data class LoginData(
    val vvid: String,
    val fullname: String
)