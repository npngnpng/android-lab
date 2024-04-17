package com.geunoo.android_lab.feature.sharebook

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.geunoo.android_lab.feature.addbook.list
import com.geunoo.android_lab.ui.component.BookInfo
import com.geunoo.android_lab.ui.component.Header
import team.returm.jobisdesignsystemv2.button.ButtonColor
import team.returm.jobisdesignsystemv2.button.JobisButton
import team.returm.jobisdesignsystemv2.textfield.JobisTextField

@Composable
fun ShareBookScreen(bookId: String) {
    val (text, onTextChange) = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        Header()
        Spacer(modifier = Modifier.padding(top = 30.dp))
        BookInfo(
            title = list[0].title,
            author = list[0].author,
            image = list[0].image,
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

        }
    }
}