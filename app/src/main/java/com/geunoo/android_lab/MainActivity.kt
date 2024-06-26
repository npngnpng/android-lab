package com.geunoo.android_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
