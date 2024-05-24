package com.geunoo.android_lab.feature.sharebook

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geunoo.android_lab.NavigationRoute
import com.geunoo.android_lab.common.LoginPreferences
import com.geunoo.android_lab.data.book.dto.request.CreateBookRequest
import com.geunoo.android_lab.data.book.dto.response.BookInfoResponse
import com.geunoo.android_lab.data.util.RetrofitClient
import com.geunoo.android_lab.ui.component.BookInfo
import com.geunoo.android_lab.ui.component.Header
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import team.returm.jobisdesignsystemv2.button.ButtonColor
import team.returm.jobisdesignsystemv2.button.JobisButton
import team.returm.jobisdesignsystemv2.textfield.JobisTextField
import team.returm.jobisdesignsystemv2.toast.JobisToast
import java.util.UUID

@Composable
fun ShareBookScreen(isbn: String, navController: NavController) {
    val (text, onTextChange) = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var bookInfo by remember {
        mutableStateOf(
            BookInfoResponse(
                title = "",
                author = "",
                description = "",
                image = "",
                isbn = "",
                link = "",
            )
        )
    }
    LaunchedEffect(key1 = Unit) {
        scope.launch(Dispatchers.IO) {
            runCatching {
                RetrofitClient.bookApi.queryBooks(
                    accessToken = LoginPreferences(context).getToken(),
                    name = isbn,
                )
            }.onSuccess { books ->
                bookInfo = books.items[0]
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

    Column(modifier = Modifier.fillMaxSize()) {
        Header()
        Spacer(modifier = Modifier.padding(top = 30.dp))
        BookInfo(
            title = bookInfo.title,
            author = bookInfo.author,
            image = bookInfo.image,
        )
        Spacer(modifier = Modifier.padding(top = 40.dp))
        JobisTextField(
            title = "책 한줄평",
            value = { text },
            hint = "입력",
            onValueChange = onTextChange,
        )
        Spacer(modifier = Modifier.weight(1f))
        JobisButton(
            color = ButtonColor.Primary,
            text = "작성 하기",
        ) {
            scope.launch(Dispatchers.IO) {
                runCatching {
                    RetrofitClient.bookApi.shareBook(
                        accessToken = LoginPreferences(context).getToken(),
                        isbn = isbn,
                        request = CreateBookRequest(
                            review = text,
                            listOf(UUID.fromString("2ff98fb0-f0e2-11ee-9dc4-e3bb01d21b10")),
                        )
                    )
                }.onSuccess {
                    withContext(Dispatchers.Main) {
                        navController.navigate(NavigationRoute.Root.route) {
                            popUpTo(0)
                        }
                        JobisToast.create(
                            context = context,
                            message = "책이 성공적으로 공유됨"
                        ).show()
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
    }
}