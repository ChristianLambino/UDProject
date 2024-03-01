package com.castres.breand.block6.p1.androidproject.dataclass

data class UserList(
    val address: String = "",
    val created_at: String,
    val email: String = "",
    val email_verified_at: Any,
    val id: Int,
    val name: String = "",
    val phone: String = "",
    val updated_at: String,
    val usertype: String,
    val password: String = ""
) {
    // No-argument constructor
    constructor() : this("", "", "", Any(), 0, "", "", "", "")
}
