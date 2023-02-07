package com.example.wetherappcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wetherappcompose.R
import com.example.wetherappcompose.ui.theme.BlueLight

/**
 *@Author Dgryzhkov
 */
@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(
        painter = painterResource(id = R.drawable.weather_bg), contentDescription = "im1",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = BlueLight,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp),

            ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "20 feb 2023 13:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.Black
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/night/113.png",
                        contentDescription = "im2", modifier = Modifier
                            .size(45.dp)
                            .padding(top = 3.dp, end = 8.dp)
                    )
                }
                Text(
                    text = "Tomsk",
                    style = TextStyle(fontSize = 24.sp),
                    color = Color.Black
                )
                Text(
                    text = "21°C",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.Black
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Black
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {

                    }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_search_24),
                            contentDescription = "im3",
                            tint = Color.Red
                        )
                    }
                    Text(
                        text = "21°C/16°C",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.Red
                    )

                    IconButton(onClick = {

                    }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_cloud_sync_24),
                            contentDescription = "im4",
                            tint = Color.Red
                        )
                    }


                }
            }

        }
    }
}