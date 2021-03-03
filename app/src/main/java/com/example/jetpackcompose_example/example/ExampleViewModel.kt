package com.example.jetpackcompose_example.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleViewModel : ViewModel() {

    // state: exampleItems
    private var _exampleItems = MutableLiveData(listOf<ExampleItem>())
    val exampleItem: LiveData<List<ExampleItem>> = _exampleItems

    // event: addItem
    fun addItem(item: ExampleItem) {
        _exampleItems.value = _exampleItems.value!! + listOf(item)
    }

    // event: removeItem
    fun removeItem(item: ExampleItem) {
        _exampleItems.value = _exampleItems.value!!.toMutableList().also {
            it.remove(item)
        }
    }
}