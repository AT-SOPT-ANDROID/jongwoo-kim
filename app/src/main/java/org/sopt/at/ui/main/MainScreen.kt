package org.sopt.at.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.ui.history.HistoryScreen
import org.sopt.at.ui.home.HomeScreen
import org.sopt.at.ui.live.LiveScreen
import org.sopt.at.ui.search.SearchScreen
import org.sopt.at.ui.shorts.ShortsScreen
import org.sopt.at.util.type.MainNaviType

@Composable
fun MainScreen(mainNaviType: MainNaviType, viewModel: MainViewModel = hiltViewModel()) {
    when(mainNaviType) {
        MainNaviType.Home -> HomeScreen(viewModel)
        MainNaviType.Shorts -> ShortsScreen()
        MainNaviType.Live -> LiveScreen()
        MainNaviType.Search -> SearchScreen()
        MainNaviType.History -> HistoryScreen()
    }
}