package com.geunoo.android_lab.data.book.dto.response

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("items") val items: List<BookInfoResponse>,
)

data class BookInfoResponse(
    @SerializedName("title") val title: String,
    @SerializedName("link") val link: String,
    @SerializedName("image") val image: String,
    @SerializedName("author") val author: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("description") val description: String,
)