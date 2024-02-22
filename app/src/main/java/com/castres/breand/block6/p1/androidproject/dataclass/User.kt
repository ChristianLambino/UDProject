package com.castres.breand.block6.p1.AndroidProject.dataclass

data class User(

    val name: String,
    val email: String,
    val email_verified_at: String?, // Assuming timestamp is represented as a string
    val phone: String,
    val address: String,
    val password: String,
    val usertype: String = "default", // Assigning default value
    val rememberToken: String? = null, // Assuming remember token is nullable
    val timestamp: Long = 0 // Assuming timestamp is represented as a Long
)

