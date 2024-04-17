package com.geunoo.android_lab.feature.addbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geunoo.android_lab.NavigationRoute
import com.geunoo.android_lab.common.LoginPreferences
import com.geunoo.android_lab.domain.entity.addbook.BooksEntity
import com.geunoo.android_lab.ui.component.BookInfo
import com.geunoo.android_lab.ui.component.Header
import team.returm.jobisdesignsystemv2.textfield.JobisTextField

val list = listOf(
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "9788934949671",
        "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
)

@Composable
fun AddBookScreen(
    navController: NavController,
) {
    val (searchText, onSearchTextChange) = remember { mutableStateOf("") }
    val context = LocalContext.current

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
            onValueChange = onSearchTextChange,
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
                    onClick = { navController.navigate(NavigationRoute.Main.SHARE_BOOK + book.bookId) }
                )
            }
        }
    }
}