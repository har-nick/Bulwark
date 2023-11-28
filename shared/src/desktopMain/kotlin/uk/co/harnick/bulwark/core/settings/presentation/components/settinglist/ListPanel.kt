package uk.co.harnick.bulwark.core.settings.presentation.components.settinglist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RowScope.ListPanel(pagerState: PagerState) {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .weight(2.5F)
    ) {
        VerticalPager(state = pagerState, userScrollEnabled = false) {
            Text(it.toString())
        }
    }
}
