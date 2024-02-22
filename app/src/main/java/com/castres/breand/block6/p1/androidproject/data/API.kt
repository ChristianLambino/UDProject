package com.castres.breand.block6.p1.androidproject.data

import com.castres.breand.block6.p1.androidproject.dataclass.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {
    @FormUrlEncoded
    @POST("registration")
    suspend fun registerUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirmPassword") confirmPassword: String,
        @Field("phone") phone: String,
        @Field("address") address: String
    ): User

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): User // Adjust the return type based on your API response
}
