package com.geunoo.android_lab.feature.shortbooks

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.geunoo.android_lab.R
import com.geunoo.android_lab.data.book.dto.response.ShortBookResponse
import com.geunoo.android_lab.data.util.RetrofitClient
import com.geunoo.android_lab.ui.component.Header
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import team.returm.jobisdesignsystemv2.foundation.JobisTheme
import team.returm.jobisdesignsystemv2.foundation.JobisTypography
import team.returm.jobisdesignsystemv2.toast.JobisToast
import team.returm.jobisdesignsystemv2.utils.clickable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortBooksScreen() {
    var showDialog by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val books = remember { mutableStateListOf<ShortBookResponse>() }
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { books.size },
    )
    var bookContent by remember { mutableStateOf("") }
    var isLiked by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        scope.launch {
            runCatching {
                RetrofitClient.bookApi.queryShortBook()
            }.onSuccess {
                books.addAll(it.books)
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

    Box {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Header()
            VerticalPager(
                modifier = Modifier.clickable(
                    enabled = true,
                    onClick = { showDialog = true },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
                state = pagerState,
            ) {
                books.getOrNull(it)?.run {
                    Book(
                        imageUrl = imageUrl,
                        title = title,
                        author = author,
                        isLiked = isLiked,
                    ) {
                        isLiked = it
                    }
                }
            }
        }
        if (showDialog) {
            ContentDialog(
                content = books[pagerState.currentPage].content,
                hideDialog = {
                    showDialog = false
                }
            )
        }
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
            .clickable(
                onClick = hideDialog,
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            )
            .verticalScroll(rememberScrollState())
            .background(Color.Black)
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

@Composable
private fun Book(
    imageUrl: String,
    title: String,
    author: String,
    isLiked: Boolean,
    setIsLiked: (Boolean) -> Unit,
) {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                modifier = Modifier
                    .aspectRatio(0.8f),
                model = imageUrl,
                contentDescription = "",
            )
            Text(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                    ),
                text = "눌러서 내용 보기",
                color = JobisTheme.colors.onSurface,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .padding(
                            start = 12.dp,
                            top = 18.dp,
                        ),
                    text = title,
                    style = JobisTypography.HeadLine,
                    color = JobisTheme.colors.onBackground,
                )
                Text(
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            start = 12.dp,
                        ),
                    text = author,
                    style = JobisTypography.Body,
                )
            }
            Icon(
                modifier = Modifier
                    .padding(
                        end = 18.dp,
                        top = 18.dp,
                    )
                    .clickable(
                        enabled = true,
                        onPressed = {},
                        onClick = { setIsLiked(!isLiked) }
                    ),
                painter = painterResource(id = if (isLiked) R.drawable.ic_like_true else R.drawable.ic_like_false),
                contentDescription = ""
            )
        }
    }
}
