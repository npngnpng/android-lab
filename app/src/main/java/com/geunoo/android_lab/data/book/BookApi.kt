package com.geunoo.android_lab.data.book

import com.geunoo.android_lab.data.book.dto.response.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookApi {

    @GET("/books")
    suspend fun queryBooks(
        @Header("Authorization") accessToken: String,
        @Query("name") name: String,
    ): BooksResponse
}