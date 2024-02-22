package com.castres.breand.block6.p1.AndroidProject


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://cyberservice-96805b7c1a96.herokuapp.com/"
    private lateinit var retrofit: Retrofit

    fun getRetrofitInstance(): Retrofit {
        if (!::retrofit.isInitialized) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}
