package com.geunoo.android_lab.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.geunoo.android_lab.ui.NavigationItems
import team.returm.jobisdesignsystemv2.foundation.JobisTheme
import team.returm.jobisdesignsystemv2.foundation.JobisTypography

val menu: List<NavigationItems> =
    listOf(NavigationItems.Home, NavigationItems.Add, NavigationItems.My)

@Composable
internal fun NavigationBar(
    navController: NavController
) {
    val currentSelectedRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route
    BottomAppBar {
        menu.forEach {
            val selected by remember { mutableStateOf(currentSelectedRoute == it.route) }
            val color by animateColorAsState(
                targetValue = if (selected) JobisTheme.colors.onBackground else JobisTheme.colors.surfaceTint,
                label = "",
            )
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(it.route) },
                icon = { Icon(painter = painterResource(id = it.icon), contentDescription = "", tint = color) },
                label = {
                    Text(
                        text = it.label,
                        style = JobisTypography.Caption,
                        color = color
                    )
                }
            )
        }
    }
}