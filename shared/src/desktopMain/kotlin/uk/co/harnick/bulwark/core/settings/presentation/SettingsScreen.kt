package uk.co.harnick.bulwark.core.settings.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import kotlinx.coroutines.launch
import uk.co.harnick.bulwark.common.di.ServiceLocator
import uk.co.harnick.bulwark.core.settings.presentation.components.navigation.NavigationPanel
import uk.co.harnick.bulwark.core.settings.presentation.components.navigation.toNavigationPanelItem
import uk.co.harnick.bulwark.core.settings.presentation.components.settinglist.ListPanel

actual data class SettingsScreen actual constructor(override val key: ScreenKey) : Screen {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val settingVM = rememberScreenModel { ServiceLocator.vmModule.settingsViewModel }
        val settingsState by settingVM.state.collectAsState()

        val pagerState = rememberPagerState(
            initialPage = 0,
            pageCount = { settingsState.settingEntries.count() }
        )
        val pagerScope = rememberCoroutineScope()

        Row(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            NavigationPanel {
                settingsState.settingEntries.mapIndexed { i, entry ->
                    val isSelected = (pagerState.targetPage == i)

                    entry.toNavigationPanelItem(
                        isSelected,
                        onClick = { pagerScope.launch { pagerState.scrollToPage(i) } }
                    )
                }
            }
            ListPanel(pagerState)
        }
    }
}
