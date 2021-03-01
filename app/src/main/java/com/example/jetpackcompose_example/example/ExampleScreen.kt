package com.example.jetpackcompose_example.example

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose_example.R


@Composable
fun ExampleRow(
    item: ExampleItem,
    onItemClicked: (ExampleItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable { onItemClicked(item) }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.task,
            softWrap = false
            )
        Icon(
            painter = painterResource(item.icon.icon),
            contentDescription = stringResource(item.icon.contentDescription)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ExampleRowPreview() {
//    val items = listOf<ExampleItem>(
//        ExampleItem(stringResource(id = R.string.task_1), ExampleIcon.Anchor),
//        ExampleItem(stringResource(id = R.string.task_2), ExampleIcon.AndroidBabe),
//        ExampleItem(stringResource(id = R.string.task_3), ExampleIcon.Bas),
//        ExampleItem(stringResource(id = R.string.task_4), ExampleIcon.Tractor),
//        ExampleItem(stringResource(id = R.string.task_5), ExampleIcon.Snow),
//        ExampleItem(stringResource(id = R.string.task_6), ExampleIcon.Bas),
//        ExampleItem(stringResource(id = R.string.task_7), ExampleIcon.Tractor),
//        ExampleItem(stringResource(id = R.string.task_8)),
//    )
    ExampleRow(
        item = ExampleItem(stringResource(id = R.string.task_1)),
        onItemClicked = { }
    )
}
















