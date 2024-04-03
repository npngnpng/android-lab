package com.geunoo.android_lab.feature.shortbooks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.geunoo.android_lab.ui.component.Header

@Composable
fun ShortBooksScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header()
    }
}