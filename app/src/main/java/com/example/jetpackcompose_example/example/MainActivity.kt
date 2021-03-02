package com.example.jetpackcompose_example.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "VVV"

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var instance: AppCompatActivity
            private set
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this

        setContent {
            ExampleScreen(
                items = listOf(),
                onAddItem = { },
                onRemoveItem = { })
        }
    }
}
