package uk.co.harnick.bulwark.core.window.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.onDrag
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize.Min
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowPlacement.Floating
import androidx.compose.ui.window.WindowPlacement.Fullscreen
import androidx.compose.ui.window.WindowPlacement.Maximized
import java.awt.Cursor
import java.awt.Cursor.DEFAULT_CURSOR
import java.awt.Cursor.MOVE_CURSOR

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FrameWindowScope.TaskbarFrame(
    content: @Composable RowScope.() -> Unit
) {
    WindowDraggableArea(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(
                onDoubleTap = {
                    window.placement = when (window.placement) {
                        Floating -> Maximized
                        Maximized -> Floating
                        Fullscreen -> Maximized
                    }
                }
            )
        }
            .onDrag(
                matcher = PointerMatcher.Primary,
                onDragStart = { window.cursor = Cursor(MOVE_CURSOR) },
                onDrag = {  },
                onDragEnd = { window.cursor = Cursor(DEFAULT_CURSOR) }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Min)
                .padding(start = 12.dp, top = 6.dp, end = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}
