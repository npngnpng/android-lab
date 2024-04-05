package com.geunoo.android_lab.feature.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geunoo.android_lab.R
import team.returm.jobisdesignsystemv2.button.ButtonColor
import team.returm.jobisdesignsystemv2.button.JobisButton
import team.returm.jobisdesignsystemv2.foundation.JobisDesignSystemV2Theme
import team.returm.jobisdesignsystemv2.textfield.JobisTextField

@Composable
fun LoginScreen() {
    val (email, onEmailChange) = remember { mutableStateOf("") }
    val (password, onPasswordChange) = remember { mutableStateOf("") }

    Column {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "",
        )
        JobisTextField(
            title = "이메일",
            value = { email },
            hint = "이메일",
            onValueChange = onEmailChange,
        )
        JobisTextField(
            title = "비밀번호",
            value = { password },
            hint = "비밀번호",
            onValueChange = onPasswordChange,
            showVisibleIcon = true,
        )
        JobisButton(
            modifier = Modifier
                .padding(top = 220.dp),
            text = "로그인",
            color = ButtonColor.Primary,
        ) {}
    }
}