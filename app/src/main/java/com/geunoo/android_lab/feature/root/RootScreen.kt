package com.geunoo.android_lab.feature.root

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.geunoo.android_lab.NavigationRoute
import com.geunoo.android_lab.feature.addbook.AddBookScreen
import com.geunoo.android_lab.feature.mypage.MyPageScreen
import com.geunoo.android_lab.feature.shortbooks.ShortBooksScreen
import com.geunoo.android_lab.ui.component.NavigationBar

@Composable
internal fun RootScreen(navHostController: NavController) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { NavigationBar(navController = navController) }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = NavigationRoute.Root.SHORT_BOOKS,
        ) {
            composable(route = NavigationRoute.Root.SHORT_BOOKS) {
                ShortBooksScreen()
            }
            composable(route = NavigationRoute.Root.ADD_BOOK) {
                AddBookScreen(navController = navHostController)
            }
            composable(route = NavigationRoute.Root.MY_PAGE) {
                MyPageScreen(navController = navHostController)
            }
        }
    }
}