package com.geunoo.android_lab.feature.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.geunoo.android_lab.NavigationRoute
import com.geunoo.android_lab.data.user.dto.request.SignUpRequest
import com.geunoo.android_lab.data.util.RetrofitClient
import com.geunoo.android_lab.ui.component.Header
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import team.returm.jobisdesignsystemv2.button.ButtonColor
import team.returm.jobisdesignsystemv2.button.JobisButton
import team.returm.jobisdesignsystemv2.textfield.JobisTextField
import team.returm.jobisdesignsystemv2.toast.JobisToast

@Composable
fun SignUpScreen(navController: NavController) {
    val (email, onEmailChange) = remember { mutableStateOf("") }
    val (password, onPasswordChange) = remember { mutableStateOf("") }
    val (name, onNameChange) = remember { mutableStateOf("") }
    var signupClicked by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(key1 = signupClicked) {
        scope.launch(Dispatchers.IO) {
            runCatching {
                RetrofitClient.userApi.signup(
                    SignUpRequest(
                        email = email,
                        password = password,
                        name = name,
                    )
                )
            }.onSuccess {
                withContext(Dispatchers.Main) {
                    JobisToast.create(
                        context = context,
                        message = "회원가입 성공",
                    ).show()
                    navController.navigate(NavigationRoute.Auth.SIGN_IN) {
                        popUpTo(0)
                    }
                }
            }.onFailure {
                withContext(Dispatchers.Main) {
                    JobisToast.create(
                        context = context,
                        message = it.message ?: "알 수 없는 오류",
                    ).show()
                }
            }
        }
    }

    Column {
        Header()
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
        JobisTextField(
            title = "이름",
            value = { name },
            hint = "이름",
            onValueChange = onNameChange,
        )
        Spacer(modifier = Modifier.weight(1f))
        JobisButton(
            enabled = password.isNotBlank() && email.isNotBlank() && name.isNotBlank(),
            text = "회원가입",
            color = ButtonColor.Primary,
            onClick = { signupClicked = true }
        )
    }
}