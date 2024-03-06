package com.castres.breand.block6.p1.androidproject.dataclass

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String,
)

