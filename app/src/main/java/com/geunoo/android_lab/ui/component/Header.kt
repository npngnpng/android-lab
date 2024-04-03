package com.geunoo.android_lab.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geunoo.android_lab.R
import team.returm.jobisdesignsystemv2.foundation.JobisTheme

@Composable
internal fun Header() {
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 8.dp,
                    horizontal = 12.dp,
                )
                .background(JobisTheme.colors.background)
        ) {
            Image(
                modifier = Modifier
                    .size(
                        width = 64.dp,
                        height = 32.dp,
                    ),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
            )
        }
        Divider(modifier = Modifier.shadow(1.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun Test() {
    Header()
}