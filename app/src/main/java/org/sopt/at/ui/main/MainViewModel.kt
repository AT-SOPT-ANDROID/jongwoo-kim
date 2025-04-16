package org.sopt.at.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.data.KeywordData
import org.sopt.at.data.MainBannerData
import org.sopt.at.data.OnAirData
import org.sopt.at.data.RankingData
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor( ) : ViewModel() {

    private var _mainBannerList = MutableStateFlow<List<MainBannerData>?>(null)
    var mainBannerList = _mainBannerList.asStateFlow()

    private var _keywordList = MutableStateFlow<List<KeywordData>?>(null)
    var keywordList = _keywordList.asStateFlow()

    private var _rankingList = MutableStateFlow<List<RankingData>?>(null)
    var rankingList = _rankingList.asStateFlow()

    private var _onAirList = MutableStateFlow<List<OnAirData>?>(null)
    var onAirList = _onAirList.asStateFlow()


    fun setMainBannerList() = viewModelScope.launch {
        val mainBannerDataList = listOf(
            MainBannerData(bannerPoster = R.drawable.drama1_poster_image, bannerContent = "드라마1 어쩌고 저쩌고"),
            MainBannerData(bannerPoster = R.drawable.drama2_poster_image, bannerContent = "드라마2 어쩌고 저쩌고"),
            MainBannerData(bannerPoster = R.drawable.drama3_poster_image, bannerContent = "드라마3 어쩌고 저쩌고"),
            MainBannerData(bannerPoster = R.drawable.drama4_poster_image, bannerContent = "드라마4 어쩌고 저쩌고"),
            MainBannerData(bannerPoster = R.drawable.drama5_poster_image, bannerContent = "드라마5 어쩌고 저쩌고"),
            MainBannerData(bannerPoster = R.drawable.drama6_poster_image, bannerContent = "드라마6 어쩌고 저쩌고"),
        ).shuffled()

        _mainBannerList.emit(mainBannerDataList)
    }

    fun setKeywordList() = viewModelScope.launch {
        val keywordDataList = listOf(
            KeywordData(keyword = "KBO", keywordPoster = R.drawable.kbo_logo),
            KeywordData(keyword = "APPLETV", keywordPoster = R.drawable.appletv_logo),
            KeywordData(keyword = "ENA", keywordPoster = R.drawable.ena_logo),
            KeywordData(keyword = "UFC", keywordPoster = R.drawable.ufc_logo),
        ).shuffled()

        _keywordList.emit(keywordDataList)
    }

    fun setRankingList() = viewModelScope.launch {
        val rankingDataList = listOf(
            RankingData(poster = R.drawable.drama1_poster_image),
            RankingData(poster = R.drawable.drama2_poster_image),
            RankingData(poster = R.drawable.drama3_poster_image),
            RankingData(poster = R.drawable.drama4_poster_image),
            RankingData(poster = R.drawable.drama5_poster_image),
            RankingData(poster = R.drawable.drama6_poster_image),
            RankingData(poster = R.drawable.drama7_poster_image),
            RankingData(poster = R.drawable.drama8_poster_image),
            RankingData(poster = R.drawable.drama9_poster_image),
            RankingData(poster = R.drawable.drama10_poster_image)
        ).shuffled()

        _rankingList.emit(rankingDataList)
    }

    fun setOnAirList() = viewModelScope.launch {
        val onAirDataList = listOf(
            OnAirData(poster = R.drawable.drama10_poster_image),
            OnAirData(poster = R.drawable.drama9_poster_image),
            OnAirData(poster = R.drawable.drama8_poster_image),
            OnAirData(poster = R.drawable.drama7_poster_image),
            OnAirData(poster = R.drawable.drama6_poster_image),
            OnAirData(poster = R.drawable.drama5_poster_image),
            OnAirData(poster = R.drawable.drama4_poster_image),
            OnAirData(poster = R.drawable.drama3_poster_image),
            OnAirData(poster = R.drawable.drama2_poster_image),
            OnAirData(poster = R.drawable.drama1_poster_image)
        ).shuffled()

        _onAirList.emit(onAirDataList)
    }
}