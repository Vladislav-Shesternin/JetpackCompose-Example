package com.example.jetpackcompose_example.example

import androidx.annotation.StringRes
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ExampleInputTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onImeAction: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = { onTextChange(it) },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hideSoftwareKeyboard()
        }),
        modifier = modifier
    )
}


@Composable
fun ExampleInputButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun ExampleItemInputBackground(
    elevation: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    val animatedElevation by animateDpAsState(
        if (elevation) 1.dp else 0.dp,
        TweenSpec(500)
    )
    Surface(
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.05F),
        elevation = animatedElevation,
        shape = RectangleShape,
    ) {
        Row(
            modifier = modifier.animateContentSize(animationSpec = TweenSpec(300)),
            content = content
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewInputTextField() {
    ExampleInputTextField(
        text = "Hello Vlad",
        onTextChange = { }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewInputButton() {
    ExampleInputButton(
        text = "Add",
        onClick = { }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewExampleItemInputBackground() {
    ExampleItemInputBackground(
        elevation = true,
        modifier = Modifier.fillMaxWidth()
    ) {
        ExampleItemInput({ })
    }
}

// ==================================================================================================

@Composable
fun SelectableIconButton(
    icon: Int,
    @StringRes iconContentDescription: Int,
    onIconSelected: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    val tint = if (isSelected) {
        MaterialTheme.colors.primary
    } else {
        MaterialTheme.colors.onSurface.copy(alpha = 0.6F)
    }
    TextButton(
        onClick = { onIconSelected() },
        shape = CircleShape,
        modifier = modifier
    ) {
        Column {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = stringResource(id = iconContentDescription),
                tint = tint
            )
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .padding(top = 3.dp)
                        .height(1.dp)
                        .width(24.dp)
                        .background(tint)
                )
            } else {
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun IconRow(
    icon: ExampleIcon,
    onIconChange: (ExampleIcon) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        for (exampleIcon in ExampleIcon.values()) {
            SelectableIconButton(
                icon = exampleIcon.icon,
                iconContentDescription = exampleIcon.contentDescription,
                onIconSelected = { onIconChange(exampleIcon) },
                isSelected = exampleIcon == icon
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedIconRow(
    icon: ExampleIcon,
    onIconChange: (ExampleIcon) -> Unit,
    modifier: Modifier = Modifier,
    visible: Boolean = true,
    initialVisibility: Boolean = false,
) {
    val enter = remember { fadeIn(animationSpec = TweenSpec(300, easing = FastOutLinearInEasing)) }
    val exit = remember { fadeOut(animationSpec = TweenSpec(100, easing = FastOutSlowInEasing)) }
    Box(modifier.defaultMinSize(minHeight = 16.dp)) {
        AnimatedVisibility(
            visible = visible,
            initiallyVisible = initialVisibility,
            enter = enter,
            exit = exit
        ) {
            IconRow(icon = icon, onIconChange = onIconChange)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewSelectableIconButton() {
    SelectableIconButton(
        icon = ExampleIcon.Tractor.icon,
        iconContentDescription = ExampleIcon.Tractor.contentDescription,
        onIconSelected = { },
        isSelected = false)
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewIconRow() {
    IconRow(
        icon = ExampleIcon.Tractor,
        onIconChange = { }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewAnimatedIconRow() {
    AnimatedIconRow(
        icon = ExampleIcon.Tractor,
        onIconChange = { })
}































