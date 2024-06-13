package com.geunoo.android_lab.feature.login

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geunoo.android_lab.NavigationRoute
import com.geunoo.android_lab.R
import com.geunoo.android_lab.common.LoginPreferences
import com.geunoo.android_lab.data.user.dto.request.LoginRequest
import com.geunoo.android_lab.data.user.dto.response.LoginResponse
import com.geunoo.android_lab.data.util.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import team.returm.jobisdesignsystemv2.button.ButtonColor
import team.returm.jobisdesignsystemv2.button.JobisButton
import team.returm.jobisdesignsystemv2.foundation.JobisTheme
import team.returm.jobisdesignsystemv2.textfield.JobisTextField
import team.returm.jobisdesignsystemv2.toast.JobisToast
import team.returm.jobisdesignsystemv2.utils.clickable

@Composable
fun LoginScreen(navController: NavController) {
    val (email, onEmailChange) = remember { mutableStateOf("") }
    val (password, onPasswordChange) = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var loginClicked by remember { mutableStateOf(false) }

    BackHandler {
        navController.navigate(NavigationRoute.Root.route)
    }

    LaunchedEffect(key1 = loginClicked) {
        if (loginClicked) {
            loginClicked = false
            scope.launch {
                runCatching {
                    login(
                        email = email,
                        password = password,
                    )
                }.onSuccess {
                    LoginPreferences(context).setToken("Bearer ${it.accessToken}")
                    navController.navigate(NavigationRoute.Root.route) {
                        popUpTo(0)
                    }
                }.onFailure {
                    withContext(Dispatchers.Main) {
                        Log.d("TEST", it.message.toString())
                        JobisToast.create(
                            context = context,
                            message = it.message ?: "알 수 없는 오류",
                        ).show()
                    }
                }
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
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
        Text(
            modifier = Modifier.clickable(
                enabled = true,
                onClick = { navController.navigate(NavigationRoute.Auth.SIGN_UP) },
                onPressed = {}
            ),
            text = "회원가입하기",
            color = Color.Gray,
            textDecoration = TextDecoration.Underline,
        )
        JobisButton(
            modifier = Modifier
                .padding(top = 220.dp),
            text = "로그인",
            color = ButtonColor.Primary,
            onClick = { loginClicked = true }
        )
    }
}

private suspend fun login(
    email: String,
    password: String,
): LoginResponse {
    return RetrofitClient.userApi.login(
        LoginRequest(
            email = email,
            password = password,
        )
    )
}