package com.castres.breand.block6.p1.androidproject.data.modeling

import com.castres.breand.block6.p1.androidproject.data.model.User
import com.castres.breand.block6.p1.androidproject.data.model.Users
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface API {

    @POST("registration")
    suspend fun registerUser(): User

    @POST("registration")
    suspend fun registerUser(@Body userData: User): Response<User>



    @GET("registration")
    suspend fun userLogin(
    ):  Users


    companion object {
        const val BASE_URL = "https://cyberservice-96805b7c1a96.herokuapp.com/"
        const val REG_URL = "https://cyberservice-96805b7c1a96.herokuapp.com/registration"
        const val LOG_URL = "https://cyberservice-96805b7c1a96.herokuapp.com/login"
    }
}
