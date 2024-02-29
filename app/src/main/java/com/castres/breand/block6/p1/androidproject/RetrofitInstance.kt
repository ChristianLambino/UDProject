package com.castres.breand.block6.p1.androidproject

import com.castres.breand.block6.p1.androidproject.data.model.modeling.API
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // Create an interceptor to add the authentication token to the request headers
    private val authTokenInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()

        // Add the authentication token to the request headers if it's not null
        val token = authToken
        val requestBuilder = originalRequest.newBuilder()
        if (token != null) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        val modifiedRequest = requestBuilder.build()
        chain.proceed(modifiedRequest)
    }

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Create OkHttpClient with the interceptor added
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(authTokenInterceptor) // Add the authentication token interceptor
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(API.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    val api: API = retrofit.create(API::class.java)

    var authToken: String? = null // Define authToken as a mutable variable

}
