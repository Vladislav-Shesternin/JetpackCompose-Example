package com.example.jetpackcompose_example.util

import android.util.Log
import com.example.jetpackcompose_example.R.string.*
import com.example.jetpackcompose_example.example.ExampleIcon
import com.example.jetpackcompose_example.example.ExampleItem
import com.example.jetpackcompose_example.example.MainActivity


fun generatorRandomExampleItem(): ExampleItem {
    val ids = listOf<Int>(
        task_1,
        task_2,
        task_3,
        task_4,
        task_5,
        task_6,
        task_7,
        task_8,
    )

    val task = MainActivity.instance.getString(ids.random())
    val icon = ExampleIcon.values().random()

    Log.i("VLAD", "${ExampleItem(task = task, icon = icon)}")

    return ExampleItem(
        task = task,
        icon = icon
    )
}