package com.castres.breand.block6.p1.androidproject.data.model.modeling

import com.castres.breand.block6.p1.androidproject.dataclass.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface API {

    @POST("registration")
    suspend fun registerUser(@Body userData: User): Call<User>

    @GET("users")
     fun userLogin(): Call<User>

}
