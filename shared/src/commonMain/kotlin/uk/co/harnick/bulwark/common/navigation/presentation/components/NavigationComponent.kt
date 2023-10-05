package uk.co.harnick.bulwark.common.navigation.presentation.components

import androidx.compose.runtime.Composable

@Composable
expect fun NavigationComponent(content: @Composable () -> Unit)
