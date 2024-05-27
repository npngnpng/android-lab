package com.geunoo.android_lab.data.util

import com.geunoo.android_lab.data.book.BookApi
import com.geunoo.android_lab.data.user.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://basically-dominant-hornet.ngrok-free.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userApi = retrofit.create(UserApi::class.java)

    val bookApi = retrofit.create(BookApi::class.java)
}
