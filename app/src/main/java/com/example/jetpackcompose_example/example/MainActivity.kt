package com.example.jetpackcompose_example.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable

private const val TAG = "VLAD"

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var instance: AppCompatActivity
            private set
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this

        setContent {
            ExampleActivityScreen()
        }
    }
}

@Composable
fun ExampleActivityScreen() {
    ExampleScreen(
        items = listOf( ),
        onAddItem = { },
        onRemoveItem = { })
}
