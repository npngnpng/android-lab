package com.geunoo.android_lab.data.book

import com.geunoo.android_lab.data.book.dto.request.CreateBookRequest
import com.geunoo.android_lab.data.book.dto.response.BooksResponse
import com.geunoo.android_lab.data.book.dto.response.QueryShortBookResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BookApi {

    @GET("/books")
    suspend fun queryBooks(
        @Header("Authorization") accessToken: String,
        @Query("name") name: String,
    ): BooksResponse

    @GET("/books/short")
    suspend fun queryShortBook(): QueryShortBookResponse

    @POST("/books/{isbn}")
    suspend fun shareBook(
        @Header("Authorization") accessToken: String,
        @Path("isbn") isbn: String,
        @Body request: CreateBookRequest,
    )

    @GET("/books/my")
    suspend fun queryMyBooks(
        @Header("Authorization") accessToken: String,
    ): QueryShortBookResponse
}