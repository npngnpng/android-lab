package com.geunoo.android_lab

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.geunoo.android_lab.feature.root.RootScreen
import com.geunoo.android_lab.feature.splash.SplashScreen

@Composable
internal fun ShortBookApp() {
    val navController = rememberNavController()
    NavHost(
        startDestination = NavigationRoute.Auth.route,
        navController = navController,
    ) {
        auth(navController)
        root()
        main()
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
    }
}

private fun NavGraphBuilder.root() {
    composable(route = NavigationRoute.Root.route) {
        RootScreen()
    }
}

private fun NavGraphBuilder.main() {
    navigation(
        startDestination = NavigationRoute.Main.SEARCH_BOOKS,
        route = NavigationRoute.Main.route,
    ) {

    }
}