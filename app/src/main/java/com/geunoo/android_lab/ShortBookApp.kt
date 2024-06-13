package com.geunoo.android_lab

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.geunoo.android_lab.feature.login.LoginScreen
import com.geunoo.android_lab.feature.root.RootScreen
import com.geunoo.android_lab.feature.share_book_history.ShareBookHistoryScreen
import com.geunoo.android_lab.feature.sharebook.ShareBookScreen
import com.geunoo.android_lab.feature.signup.SignUpScreen
import com.geunoo.android_lab.feature.splash.SplashScreen

@Composable
internal fun ShortBookApp() {
    val navController = rememberNavController()
    NavHost(
        startDestination = NavigationRoute.Auth.route,
        navController = navController,
    ) {
        auth(navController)
        root(navController)
        main(navController)
    }
}

private fun NavGraphBuilder.auth(navController: NavController) {
    navigation(
        startDestination = NavigationRoute.Auth.SPLASH,
        route = NavigationRoute.Auth.route,
    ) {
        composable(route = NavigationRoute.Auth.SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(route = NavigationRoute.Auth.SIGN_IN) {
            LoginScreen(navController = navController)
        }
        composable(route = NavigationRoute.Auth.SIGN_UP) {
            SignUpScreen(navController = navController)
        }
    }
}

private fun NavGraphBuilder.root(navController: NavController) {
    composable(route = NavigationRoute.Root.route) {
        RootScreen(navHostController = navController)
    }
}

private fun NavGraphBuilder.main(navController: NavController) {
    navigation(
        startDestination = NavigationRoute.Main.SEARCH_BOOKS,
        route = NavigationRoute.Main.route,
    ) {
        composable(
            route = NavigationRoute.Main.SHARE_BOOK + "{isbn}",
            arguments = listOf(navArgument("isbn") { type = NavType.StringType })
        ) {
            val isbn = it.arguments?.getString("isbn") ?: ""
            ShareBookScreen(isbn = isbn, navController = navController)
        }
        composable(
            route = NavigationRoute.Main.SHARE_BOOK_HISTORY,
        ) {
            ShareBookHistoryScreen()
        }
    }
}