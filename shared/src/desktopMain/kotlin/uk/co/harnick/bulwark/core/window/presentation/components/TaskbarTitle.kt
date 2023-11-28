package uk.co.harnick.bulwark.core.window.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TaskbarTitle() {
    Text(
        text = "Bulwark",
        style = MaterialTheme.typography.titleMedium
    )
}
