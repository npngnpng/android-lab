package com.geunoo.android_lab.feature.shortbooks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.geunoo.android_lab.R
import com.geunoo.android_lab.ui.component.Header
import team.returm.jobisdesignsystemv2.foundation.JobisTheme
import team.returm.jobisdesignsystemv2.foundation.JobisTypography

@Composable
fun ShortBooksScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()
        Image(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 26.dp,
                    end = 26.dp,
                )
                .shadow(10.dp),
            painter = painterResource(R.drawable.ic_book),
            contentDescription = "임시",
        )
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
            text = "눌러서 내용 보기",
            color = JobisTheme.colors.onSurface,
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            JobisTheme.colors.onSurfaceVariant,
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .padding(
                            start = 12.dp,
                            top = 18.dp,
                        ),
                    text = "우리는 여전히 삶을 사랑하는가",
                    style = JobisTypography.HeadLine,
                    color = JobisTheme.colors.onBackground,
                )
                Text(
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            start = 12.dp,
                        ),
                    text = "에리히 프롬",
                    style = JobisTypography.Body,
                )
            }
            Icon(
                modifier = Modifier
                    .padding(
                        start = 80.dp,
                        end = 18.dp,
                        top = 18.dp,
                    ),
                painter = painterResource(id = R.drawable.ic_like_false),
                contentDescription = ""
            )
        }
    }
}