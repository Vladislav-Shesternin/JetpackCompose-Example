package com.example.jetpackcompose_example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose_example.ui.theme.JetpackComposeExampleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ShowPreview() {
    Greeting(name = "Android")
}

@Composable
fun Greeting(name: String) {
    JetpackComposeExampleTheme {
        Text(
            color = Color.Blue,
            text = "Hello $name!",
            style = MaterialTheme.typography.body1,
        )
    }
}