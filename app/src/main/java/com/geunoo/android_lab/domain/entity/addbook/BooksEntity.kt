package com.geunoo.android_lab.domain.entity.addbook

data class BooksEntity(
    val books: List<BookEntity>,
) {
    data class BookEntity(
        val bookId: String,
        val image: String,
        val title: String,
        val author: String,
    )
}