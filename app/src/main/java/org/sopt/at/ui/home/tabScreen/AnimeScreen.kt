package org.sopt.at.ui.home.tabScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.ui.home.contents.KeywordScreen
import org.sopt.at.ui.home.contents.MainBannerScreen
import org.sopt.at.ui.home.contents.OnAirScreen
import org.sopt.at.ui.home.contents.RankingScreen
import org.sopt.at.ui.main.MainViewModel

@Composable
fun AnimeScreen(viewModel: MainViewModel = hiltViewModel()) {
    viewModel.setMainBannerList()
    viewModel.setKeywordList()
    viewModel.setRankingList()
    viewModel.setOnAirList()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            MainBannerScreen(viewModel)
        }

        item {
            KeywordScreen(viewModel)
        }

        item {
            RankingScreen(viewModel)
        }

        item {
            OnAirScreen(viewModel)
        }
    }
}