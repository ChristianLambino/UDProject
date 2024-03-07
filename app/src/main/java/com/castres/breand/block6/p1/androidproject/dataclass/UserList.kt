package com.castres.breand.block6.p1.androidproject.dataclass

import com.google.gson.annotations.SerializedName

data class UserList(
    @SerializedName("address")
    val address: String = "",
    val created_at: String,
    @SerializedName("email")
    val email: String,
    val email_verified_at: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    val updated_at: String,
    val usertype: String,
    @SerializedName("password")
    val password: String
)
