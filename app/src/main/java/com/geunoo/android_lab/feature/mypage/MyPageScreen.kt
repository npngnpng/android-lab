package com.geunoo.android_lab.feature.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.geunoo.android_lab.R
import com.geunoo.android_lab.ui.component.Header
import team.returm.jobisdesignsystemv2.foundation.JobisIcon
import team.returm.jobisdesignsystemv2.foundation.JobisTheme
import team.returm.jobisdesignsystemv2.foundation.JobisTypography

val list = listOf("개발", "문학", "비문학")

@Composable
fun MyPageScreen() {
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
        )
        Menu(
            text = "로그아웃",
            painter = painterResource(id = JobisIcon.LogOut),
            tint = JobisTheme.colors.error,
        )
        Menu(
            text = "회원 탈퇴",
            painter = painterResource(id = JobisIcon.PersonRemove),
            tint = JobisTheme.colors.error,
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
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
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