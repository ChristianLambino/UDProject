package com.castres.breand.block6.p1.androidproject.data.model.modeling

import com.castres.breand.block6.p1.androidproject.dataclass.LoginResponse
import com.castres.breand.block6.p1.androidproject.dataclass.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {

    @POST("registration")
    suspend fun registerUser(@Body userData: User): Response<User>

    @GET("users")
    fun userLogin(): Call<User>

    @GET("checkEmail")
    suspend fun checkEmail(@Query("email") email: String): Response<LoginResponse>
}

