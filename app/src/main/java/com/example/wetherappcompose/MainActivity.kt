package com.example.wetherappcompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.wetherappcompose.ui.theme.WetherAppComposeTheme
import org.json.JSONObject

const val API_KEY = "7c3a302d7b024735ab554908230302"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WetherAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Tomsk", this)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, context: Context) {
    val state = remember {
        mutableStateOf("Unknown")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Temp in  $name = ${state.value} C")
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Button(
                onClick = {
                    getResult(name,state, context)
                }, modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Refresh")
            }

        }
    }

}

private fun getResult(city: String, state: MutableState<String>, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY" +
            "&q=$city" +
            "&days=" +
            "3" +
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url, { response ->
            val obj = JSONObject(response)
            state.value = obj.getJSONObject("current").getString("temp_c")
        },
        { error ->
        }

    )
    queue.add(stringRequest)
}