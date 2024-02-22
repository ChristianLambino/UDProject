package com.castres.breand.block6.p1.androidproject

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://cyberservice-96805b7c1a96.herokuapp.com/"
    private lateinit var retrofit: Retrofit

    fun getRetrofitInstance(): Retrofit {
        if (!::retrofit.isInitialized) {
            // Create Gson instance with lenient mode
            val gson = GsonBuilder().setLenient().create()

            // Configure Retrofit with GsonConverterFactory and lenient mode
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit
    }
}
