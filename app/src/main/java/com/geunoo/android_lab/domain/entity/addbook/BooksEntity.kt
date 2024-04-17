package com.geunoo.android_lab.domain.entity.addbook

data class BooksEntity(
    val books: List<BookEntity>,
) {
    data class BookEntity(
        val title: String,
        val link: String,
        val image: String,
        val author: String,
        val isbn: String,
        val description: String,
    )
}