package com.geunoo.android_lab

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
internal fun ShortBookApp() {
    val navController = rememberNavController()
    NavHost(
        startDestination = NavigationRoute.Auth.route,
        navController = navController,
    ) {
        auth()
        root()
        main()
    }
}

private fun NavGraphBuilder.auth() {
    navigation(
        startDestination = NavigationRoute.Auth.SPLASH,
        route = NavigationRoute.Auth.route,
    ) {

    }
}

private fun NavGraphBuilder.root() {
    navigation(
        startDestination = NavigationRoute.Root.SHORT_BOOKS,
        route = NavigationRoute.Root.route,
    ) {

    }
}

private fun NavGraphBuilder.main() {
    navigation(
        startDestination = NavigationRoute.Main.SEARCH_BOOKS,
        route = NavigationRoute.Main.route,
    ) {

    }
}