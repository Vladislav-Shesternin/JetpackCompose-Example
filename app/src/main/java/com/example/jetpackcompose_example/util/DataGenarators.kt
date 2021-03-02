package com.example.jetpackcompose_example.util

import com.example.jetpackcompose_example.R.string.*
import com.example.jetpackcompose_example.example.ExampleIcon
import com.example.jetpackcompose_example.example.ExampleItem
import com.example.jetpackcompose_example.example.MainActivity

/**
 * Method of generating ExampleItem [generatorRandomExampleItem]
 * Contains a ListOf ID of string resources [ids], for convenience [R.strings] are placed in import.
 * */
fun generatorRandomExampleItem(): ExampleItem {
    val stringsIds = listOf<Int>(
        task_1,
        task_2,
        task_3,
        task_4,
        task_5,
        task_6,
        task_7,
        task_8,
    )

    // Getting a random string resource
    val task = MainActivity.instance.getString(stringsIds.random())
    // Getting a random icon
    val icon = ExampleIcon.values().random()

    return ExampleItem(
        task = task,
        icon = icon
    )
}