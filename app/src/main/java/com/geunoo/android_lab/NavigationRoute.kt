package com.geunoo.android_lab

sealed class NavigationRoute(val route: String) {
    data object Auth : NavigationRoute(route = "auth") {
        val SPLASH = this.route + "/splash"
        val SIGN_IN = this.route + "/signIn"
        val SIGN_UP = this.route + "/signUp"
    }

    data object Root : NavigationRoute(route = "root") {
        val SHORT_BOOKS = this.route + "/shortBooks"
        val ADD_BOOK = this.route + "/addBook"
        val MY_PAGE = this.route + "/myPage"
    }

    data object Main : NavigationRoute(route = "main") {
        val SEARCH_BOOKS = this.route + "/searchBooks"
        val SHARE_BOOK = this.route + "/shareBook"
        val SHARE_BOOK_HISTORY = this.route +"/shareBookHistory"
    }
}