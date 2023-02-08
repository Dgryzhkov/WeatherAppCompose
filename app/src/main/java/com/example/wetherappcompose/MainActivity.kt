package com.example.wetherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.wetherappcompose.ui.screens.MainCard
import com.example.wetherappcompose.ui.screens.TabLayout
import com.example.wetherappcompose.ui.theme.WetherAppComposeTheme

const val API_KEY = "7c3a302d7b024735ab554908230302"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WetherAppComposeTheme {
                Image(
                    painter = painterResource(id = R.drawable.weather_bg), contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    MainCard()
                    TabLayout()

                }
            }
        }
    }
}
