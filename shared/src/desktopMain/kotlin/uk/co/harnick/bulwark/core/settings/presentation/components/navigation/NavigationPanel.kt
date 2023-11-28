package uk.co.harnick.bulwark.core.settings.presentation.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.NavigationPanel(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .clip(CardDefaults.shape)
            .fillMaxHeight()
            .weight(1F)
            .background(MaterialTheme.colorScheme.surface)
            .padding(12.dp),
        content = content,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    )
}
