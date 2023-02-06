package com.example.wetherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wetherappcompose.ui.screens.MainScreen
import com.example.wetherappcompose.ui.theme.WetherAppComposeTheme

const val API_KEY = "7c3a302d7b024735ab554908230302"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WetherAppComposeTheme {
                MainScreen()
            }
        }
    }
}
