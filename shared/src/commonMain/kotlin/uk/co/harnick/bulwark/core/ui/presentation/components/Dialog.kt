package uk.co.harnick.bulwark.core.ui.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon

@Composable
fun Dialog(
    isVisible: Boolean,
    title: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    icon: ImageVector? = null,
    body: (@Composable () -> Unit)? = null,
    confirmText: String? = "Confirm",
    dismissText: String? = "Dismiss"
) {
    AnimatedVisibility(isVisible) {
        AlertDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                confirmText?.let {
                    TextButton(
                        onClick = onConfirm,
                        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                        content = { Text(it) }
                    )
                }
            },
            modifier = Modifier.width(Max),
            dismissButton = {
                dismissText?.let {
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                        content = { Text(it) }
                    )
                }
            },
            icon = { icon?.let { Icon(it, contentDescription = null) } },
            title = { Text(title) },
            text = body
        )
    }
}
