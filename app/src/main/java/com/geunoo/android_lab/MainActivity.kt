package com.geunoo.android_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.geunoo.android_lab.ui.theme.AndroidlabTheme
import team.returm.jobisdesignsystemv2.foundation.JobisDesignSystemV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobisDesignSystemV2Theme(darkTheme = false) {
                ShortBookApp()
            }
        }
    }
}
