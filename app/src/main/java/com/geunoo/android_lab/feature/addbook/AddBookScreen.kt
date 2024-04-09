package com.geunoo.android_lab.feature.addbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geunoo.android_lab.domain.entity.addbook.BooksEntity
import com.geunoo.android_lab.ui.component.BookInfo
import com.geunoo.android_lab.ui.component.Header
import team.returm.jobisdesignsystemv2.textfield.JobisTextField

// TODO 데이터 클래스를 만들어
// TODO 그 데이터 클래스로 리스트를 만들어
// TODO val list = listOf<DataClass>()

val list = listOf(
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
    BooksEntity.BookEntity(
        "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
        "우리는 여전히 삶을 사랑하는가",
        "에리히 프롬"
    ),
)

@Composable
fun AddBookScreen(
    navController: NavController,
) {
    val (searchText, onSearchTextChange) = remember { mutableStateOf("") }
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
            // TODO 만든 리스트를 여기다가 넣고
            items(list) {
                BookInfo(
                    title = it.title,
                    author = it.author,
                    image = it.image,
                )
//                TODO 여기다가 각 아이템 퍼블리싱한 함수를 호출해서 데이터를 넘겨
            }
        }
    }
}