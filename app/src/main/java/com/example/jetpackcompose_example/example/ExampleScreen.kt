package com.example.jetpackcompose_example.example

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose_example.R
import com.example.jetpackcompose_example.util.generatorRandomExampleItem

private const val TAG = "VLAD"

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
        Text(text = item.task)
        Icon(
            painter = painterResource(item.icon.icon),
            contentDescription = stringResource(item.icon.contentDescription)
        )
    }
}

@Composable
fun ExampleScreen(
    items: List<ExampleItem>,
    onAddItem: (ExampleItem) -> Unit,
    onRemoveItem: (ExampleItem) -> Unit
) {
    Column {
        LazyColumn(
            modifier = Modifier.weight(1F),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = items) {
                ExampleRow(
                    item = it,
                    onItemClicked = { onRemoveItem(it) },
                    modifier = Modifier.fillParentMaxWidth()
                )
            }
        }
        Button(
            onClick = { onAddItem(generatorRandomExampleItem()) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Add random item")
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ExampleRowPreview() {
    ExampleRow(
        item = ExampleItem(stringResource(id = R.string.task_1)),
        onItemClicked = { }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ExampleScreenPreview() {
    val items = listOf<ExampleItem>(
        ExampleItem(stringResource(id = R.string.task_1), ExampleIcon.Anchor),
        ExampleItem(stringResource(id = R.string.task_2), ExampleIcon.AndroidBabe),
        ExampleItem(stringResource(id = R.string.task_3), ExampleIcon.Bas),
        ExampleItem(stringResource(id = R.string.task_4), ExampleIcon.Tractor),
        ExampleItem(stringResource(id = R.string.task_5), ExampleIcon.Snow),
        ExampleItem(stringResource(id = R.string.task_6), ExampleIcon.Bas),
        ExampleItem(stringResource(id = R.string.task_7), ExampleIcon.Tractor),
        ExampleItem(stringResource(id = R.string.task_8)),
    )

    ExampleScreen(
        items = items,
        onAddItem = { },
        onRemoveItem = { }
    )
}
















