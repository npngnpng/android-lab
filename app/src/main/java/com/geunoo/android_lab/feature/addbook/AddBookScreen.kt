package com.geunoo.android_lab.feature.addbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geunoo.android_lab.NavigationRoute
import com.geunoo.android_lab.common.LoginPreferences
import com.geunoo.android_lab.data.book.dto.response.BookInfoResponse
import com.geunoo.android_lab.data.book.dto.response.BooksResponse
import com.geunoo.android_lab.data.util.RetrofitClient
import com.geunoo.android_lab.domain.entity.addbook.BooksEntity
import com.geunoo.android_lab.ui.component.BookInfo
import com.geunoo.android_lab.ui.component.Header
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import team.returm.jobisdesignsystemv2.textfield.JobisTextField
import team.returm.jobisdesignsystemv2.toast.JobisToast

val list = mutableListOf<BookInfoResponse>()

@Composable
fun AddBookScreen(
    navController: NavController,
) {
    val (searchText, onSearchTextChange) = remember { mutableStateOf("") }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        if (!LoginPreferences(context).isLogin()) {
            navController.navigate(NavigationRoute.Auth.SIGN_IN) {
                popUpTo(0)
            }
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()
        JobisTextField(
            value = { searchText },
            hint = "책 검색",
            onValueChange = {
                scope.launch {
                    runCatching {
                        RetrofitClient.bookApi.queryBooks(
                            accessToken = LoginPreferences(context).getToken(),
                            name = it,
                        )
                    }.onSuccess { books ->
                        list.clear()
                        list.addAll(books.items)
                    }.onFailure {
                        withContext(Dispatchers.Main) {
                            JobisToast.create(
                                context = context,
                                message = it.message ?: "알 수 없는 오류",
                            ).show()
                        }
                    }
                }
                onSearchTextChange(it)
            },
            title = "",
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(list) { book ->
                BookInfo(
                    title = book.title,
                    author = book.author,
                    image = book.image,
                    onClick = { navController.navigate(NavigationRoute.Main.SHARE_BOOK + book.isbn) }
                )
            }
        }
    }
}