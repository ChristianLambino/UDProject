package com.castres.breand.block6.p1.AndroidProject.data

import com.castres.breand.block6.p1.AndroidProject.dataclass.Users
import retrofit2.http.GET

interface API {

    @GET("Users")
    suspend fun getUsersList(): Users

    companion object{
        const val BASE_URL = "https://cyberservice-96805b7c1a96.herokuapp.com/login"
    }


}