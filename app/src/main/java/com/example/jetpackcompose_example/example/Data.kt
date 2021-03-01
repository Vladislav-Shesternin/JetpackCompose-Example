package com.example.jetpackcompose_example.example

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.jetpackcompose_example.R

data class ExampleItem(
    val task: String,
    val icon: ExampleIcon = ExampleIcon.Default,
)

enum class ExampleIcon(
    @DrawableRes val icon: Int,
    @StringRes val contentDescription: Int
) {
    Anchor(R.drawable.ic_anchor_24, R.string.cd_anchor),
    AndroidBabe(R.drawable.ic_android_babe_24, R.string.cd_android_babe),
    Bas(R.drawable.ic_bas_24, R.string.cd_bas),
    Snow(R.drawable.ic_snow_24, R.string.cd_snow),
    Tractor(R.drawable.ic_tractor_24, R.string.cd_tractor);

    companion object {
        val Default = Anchor
    }
}