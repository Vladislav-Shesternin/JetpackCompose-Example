package com.example.jetpackcompose_example.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue

private const val TAG = "VLAD"

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ExampleViewModel>()

    companion object {
        lateinit var instance: AppCompatActivity
            private set
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this

        setContent {
            ExampleActivityScreen(viewModel)
        }
    }
}

@Composable
fun ExampleActivityScreen(viewModel: ExampleViewModel) {
    val items: List<ExampleItem> by viewModel.exampleItem.observeAsState(initial = listOf())
    ExampleScreen(
        items = items,
        onAddItem = { viewModel.addItem(it) },
        onRemoveItem = { viewModel.removeItem(it) }
    )
}
