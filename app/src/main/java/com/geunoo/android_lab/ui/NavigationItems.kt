package com.geunoo.android_lab.ui

import androidx.annotation.DrawableRes
import com.geunoo.android_lab.NavigationRoute
import com.geunoo.android_lab.R

sealed class NavigationItems(
    val label: String,
    val route: String,
    @DrawableRes val icon: Int,
) {
    data object Home : NavigationItems(
        label = "홈",
        route = NavigationRoute.Main.SEARCH_BOOKS,
        icon = R.drawable.ic_home,
    )

    data object Add : NavigationItems(
        label = "추가하기",
        route = NavigationRoute.Main.SHARE_BOOK,
        icon = R.drawable.ic_add,
    )

    data object My : NavigationItems(
        label = "마이페이지",
        route = NavigationRoute.Root.MY_PAGE,
        icon = R.drawable.ic_my
    )
}