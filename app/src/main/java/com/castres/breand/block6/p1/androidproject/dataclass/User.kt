package com.castres.breand.block6.p1.androidproject.dataclass

data class User(
    val user: UserList,
    val token: Token
)

data class Token(
    val name: String,
    val abilities: List<String>,
    val expires_at: Any?,
    val tokenable_id: Int,
    val tokenable_type: String,
    val updated_at: String,
    val created_at: String,
    val id: Int
)
