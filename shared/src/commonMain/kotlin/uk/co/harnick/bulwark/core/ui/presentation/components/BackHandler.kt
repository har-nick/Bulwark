package uk.co.harnick.bulwark.core.ui.presentation.components

import androidx.compose.runtime.Composable

// Abstracted as BackHandler is Android only
@Composable
expect fun BackHandler(enabled: Boolean = true, onBack: () -> Unit)