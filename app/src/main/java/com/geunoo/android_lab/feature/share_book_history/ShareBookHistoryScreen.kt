package com.geunoo.android_lab.feature.share_book_history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.geunoo.android_lab.common.LoginPreferences
import com.geunoo.android_lab.data.book.dto.response.ShortBookResponse
import com.geunoo.android_lab.data.util.RetrofitClient
import com.geunoo.android_lab.ui.component.BookInfo
import com.geunoo.android_lab.ui.component.Header
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import team.returm.jobisdesignsystemv2.toast.JobisToast

@Composable
fun ShareBookHistoryScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val bookInfo = remember { mutableStateListOf<ShortBookResponse>() }

    LaunchedEffect(Unit) {
        scope.launch(Dispatchers.IO) {
            runCatching {
                RetrofitClient.bookApi.queryMyBooks(
                    accessToken = LoginPreferences(context).getToken(),
                )
            }.onSuccess { books ->
                bookInfo.addAll(books.books)
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
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(bookInfo) { book ->
                BookInfo(
                    title = book.title,
                    author = book.author,
                    image = book.imageUrl,
                    onClick = { }
                )
            }
        }
    }
}