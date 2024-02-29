package com.castres.breand.block6.p1.androidproject.data.model.modeling

import com.castres.breand.block6.p1.androidproject.dataclass.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface API {

    @POST("registration")
    suspend fun registerUser(@Body userData: User): Response<Void>

    @POST("login")
    suspend fun userLogin(@Body loginData: User): Response<Void>

    companion object {
        const val BASE_URL = "https://cyberservice-96805b7c1a96.herokuapp.com/"
    }
}