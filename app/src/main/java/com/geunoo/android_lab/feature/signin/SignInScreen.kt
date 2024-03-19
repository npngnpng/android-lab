package com.geunoo.android_lab.feature.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geunoo.android_lab.R
import team.returm.jobisdesignsystemv2.foundation.JobisDesignSystemV2Theme
import team.returm.jobisdesignsystemv2.foundation.JobisIcon
import team.returm.jobisdesignsystemv2.foundation.JobisTheme
import team.returm.jobisdesignsystemv2.foundation.JobisTypography

@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SignInTopBar(onClick = {})
        SignInTitle()
        SignInButton(
            text = "로그인",
            onClick = {},
        )
    }
}

@Composable
fun SignInTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 20.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(JobisTheme.colors.onPrimary)) {
                    append("JOBIS")
                }
                withStyle(style = SpanStyle(Color.Black)) {
                    append("에 로그인하기")
                }
            },
            fontFamily = FontFamily(Font(team.returm.jobisdesignsystemv2.R.font.pretendard_bold)),
            fontSize = 24.sp,
        )
        Divider(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .padding(horizontal = 12.dp)
        )
        Icon(
            painter = painterResource(JobisIcon.MeetingRoom),
            contentDescription = "미팅룸",
            tint = JobisTheme.colors.onPrimary
        )
    }
}

@Composable
fun SignInButton(
    text: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 12.dp
            )
            .background(
                color = JobisTheme.colors.onPrimary,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(vertical = 16.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = text,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.pretendard)),
        )
    }
}

@Composable
fun SignInTopBar(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 8.dp
            )
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = JobisIcon.Arrow),
            contentDescription = "화살표",
        )
    }
}

@Composable
fun TextField(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 12.dp,
            )
    ) {
        Text(
            text = title,
            style = JobisTypography.Description,
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    JobisDesignSystemV2Theme {
        SignInScreen()
//        TextField("이메일", "") {}
    }
}