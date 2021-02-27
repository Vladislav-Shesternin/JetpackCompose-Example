package com.example.jetpackcompose_example

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class ColorChoice(
    private val onColor: Color,
    private val offColor: Color
) {
    var isOn = false
    var color by mutableStateOf(offColor)
    fun toggle() {
        isOn = !isOn
        color = if (isOn) onColor else offColor
    }
}