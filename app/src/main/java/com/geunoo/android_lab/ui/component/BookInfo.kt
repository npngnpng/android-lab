package com.geunoo.android_lab.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import team.returm.jobisdesignsystemv2.foundation.JobisTypography

@Composable
fun BookInfo(
    title: String,
    author: String,
    image: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .shadow(elevation = 4.dp)
            .background(Color.White)
            .padding(
                horizontal = 8.dp,
                vertical = 6.dp,
            ),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImage(
            modifier = Modifier.size(
                width = 64.dp,
                height = 96.dp,
            ),
            model = image,
            contentDescription = "cat image"
        )
        Column {
            Text(
                text = title,
                style = JobisTypography.HeadLine,
            )
            Text(
                text = author,
                style = JobisTypography.Body,
            )
        }
    }
}