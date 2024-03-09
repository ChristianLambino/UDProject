package com.castres.breand.block6.p1.androidproject.dataclass

import android.media.session.MediaSession

data class LoginResponse(val user: User, val token: MediaSession.Token)

data class LoginRequest(val email: String, val password: String)

data class RegistrationRequest(
    val email: String,
    val name: String,
    val password: String,
    val password_confirmation: String,
    val phone: String,
    val address: String
)

data class UserResponse(val User: User,  val token: MediaSession.Token)

data class EmailCheckRequest(
    val email: String
)