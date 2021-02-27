package com.example.jetpackcompose_example

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : AppCompatActivity() {
    private val TAG = this::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

private const val TAG = "VVV"

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun Show() {
    Switch()
}

@Composable
fun Switch() {
    var isGrayScale = false
    val colorChoice by remember(isGrayScale) {
        mutableStateOf(
            if (isGrayScale) {
                ColorChoice(
                    onColor = Color.White,
                    offColor = Color.Black
                )
            } else {
                ColorChoice(
                    onColor = Color.Green,
                    offColor = Color.Red
                )
            }
        )
    }
    var isOn by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorChoice.color)
    ) {
        Button(
            modifier = Modifier
                .padding(60.dp)
                .fillMaxSize(),
            onClick = { isOn = !isOn }
        ) {
            Text(
                text = if (isOn) "On" else "Off",
                color = colorChoice.color,
                fontSize = 48.sp
            )
        }
    }
    Switch(
        modifier = Modifier
            .padding(60.dp)
            .fillMaxWidth(),
        checked = isGrayScale,
        onCheckedChange = {isGrayScale = !isGrayScale}
    )
}

@Composable
fun Greeting() {
    Log.i(TAG, "Greeting: --------------------------")
    Text(text = "Hello")
}