package com.geunoo.android_lab.feature.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geunoo.android_lab.NavigationRoute
import com.geunoo.android_lab.common.LoginPreferences
import com.geunoo.android_lab.ui.component.Header
import team.returm.jobisdesignsystemv2.foundation.JobisIcon
import team.returm.jobisdesignsystemv2.foundation.JobisTheme
import team.returm.jobisdesignsystemv2.foundation.JobisTypography
import team.returm.jobisdesignsystemv2.utils.clickable

val list = listOf("개발", "문학", "비문학")

@Composable
fun MyPageScreen(navController: NavController) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        if (!LoginPreferences(context).isLogin()) {
            navController.navigate(NavigationRoute.Auth.SIGN_IN) {
                popUpTo(0)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()
        Text(
            modifier = Modifier
                .padding(
                    top = 80.dp,
                    bottom = 24.dp,
                ),
            text = "길근우",
            style = JobisTypography.PageTitle,
        )
        Row(
            modifier = Modifier
                .padding(bottom = 40.dp)
        ) {
            list.forEach {
                Category(text = it)
            }
        }
        Menu(
            text = "내 숏북",
            painter = painterResource(id = JobisIcon.Code),
            tint = JobisTheme.colors.onPrimary,
            onClick = {}
        )
        Menu(
            text = "로그아웃",
            painter = painterResource(id = JobisIcon.LogOut),
            tint = JobisTheme.colors.error,
        ) {
            LoginPreferences(context = context).deleteToken()
            navController.navigate(NavigationRoute.Root.route) {
                popUpTo(0)
            }
        }
        Menu(
            text = "회원 탈퇴",
            painter = painterResource(id = JobisIcon.PersonRemove),
            tint = JobisTheme.colors.error,
            onClick = {}
        )
    }
}

@Composable
private fun Category(
    text: String,
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(JobisTheme.colors.inverseSurface)
            .padding(
                horizontal = 12.dp,
                vertical = 4.dp,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = JobisTypography.Body,
            color = JobisTheme.colors.onPrimary,
        )
    }
}

@Composable
private fun Menu(
    text: String,
    painter: Painter,
    tint: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = onClick,
                onPressed = {}
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    top = 12.dp,
                    bottom = 12.dp
                ),
            painter = painter,
            contentDescription = "",
            tint = tint,
        )
        Text(
            modifier = Modifier
                .padding(start = 8.dp),
            text = text,
        )
    }
}
