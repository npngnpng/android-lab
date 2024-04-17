package com.geunoo.android_lab.feature.shortbooks

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.geunoo.android_lab.R
import com.geunoo.android_lab.ui.component.Header
import team.returm.jobisdesignsystemv2.foundation.JobisTheme
import team.returm.jobisdesignsystemv2.foundation.JobisTypography
import team.returm.jobisdesignsystemv2.utils.clickable

@Composable
fun ShortBooksScreen() {
    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                enabled = true,
                onPressed = {},
                onClick = { setShowDialog(true) },
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()
        AsyncImage(
            modifier = Modifier
                .aspectRatio(0.8f),
            model = "https://shopping-phinf.pstatic.net/main_3246548/32465489651.20230912084105.jpg",
            contentDescription = "",
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    bottom = 16.dp,
                )
                .clickable(
                    enabled = true,
                    onPressed = {},
                    onClick = { setShowDialog(true) },
                ),
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
    if (showDialog) {
        ContentDialog(
            content = "dajldskajdklsajdklsadjklsadjkasljdklasjdkalsjdklajdkldasjkljsakljdkl",
            hideDialog = {
                setShowDialog(false)
                Log.d("TEST", showDialog.toString())
            }
        )
    }
}

@Composable
fun ContentDialog(
    content: String,
    hideDialog: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.8f)
            .background(Color.Black)
            .clickable(
                enabled = true,
                onPressed = {},
                onClick = hideDialog,
            )
            .padding(
                horizontal = 34.dp,
                vertical = 18.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = content,
            color = JobisTheme.colors.background,
            style = JobisTypography.Body,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.clickable(
                enabled = true,
                onPressed = {},
                onClick = hideDialog,
            ),
            text = "눌러서 돌아가기",
            style = JobisTypography.Caption,
            color = JobisTheme.colors.surfaceTint,
        )
    }
}