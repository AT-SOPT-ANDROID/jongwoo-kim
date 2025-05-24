package org.sopt.at.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.domain.dataSource.HomeCategoryData
import org.sopt.at.domain.dataSource.KeywordData
import org.sopt.at.domain.dataSource.VideoData
import org.sopt.at.di.ServicePool
import org.sopt.at.util.MyApplication.Companion.USER_ID
import org.sopt.at.util.MyApplication.Companion.prefs
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor( ) : ViewModel() {

    private val _mainBannerList = MutableStateFlow<List<VideoData>?>(null)
    val mainBannerList = _mainBannerList.asStateFlow()

    private val _keywordList = MutableStateFlow<List<KeywordData>?>(null)
    val keywordList = _keywordList.asStateFlow()

    private val _rankingList = MutableStateFlow<List<VideoData>?>(null)
    val rankingList = _rankingList.asStateFlow()

    private val _onAirList = MutableStateFlow<List<VideoData>?>(null)
    val onAirList = _onAirList.asStateFlow()

    private val _homeCategoryList = MutableStateFlow<List<HomeCategoryData>?>(null)
    val homeCategoryList = _homeCategoryList.asStateFlow()

    private val _myInfo = MutableStateFlow<String?>(null)
    val myInfo = _myInfo.asStateFlow()

    private val _searchResultList = MutableStateFlow<List<String>?>(null)
    val searchResultList = _searchResultList.asStateFlow()
    
    

    fun setHomeCategoryList() = viewModelScope.launch {
        val homeCategoryDataList = listOf(
            HomeCategoryData(categoryNameResId = R.string.home_tab_drama),
            HomeCategoryData(categoryNameResId = R.string.home_tab_variety),
            HomeCategoryData(categoryNameResId = R.string.home_tab_movie),
            HomeCategoryData(categoryNameResId = R.string.home_tab_sports),
            HomeCategoryData(categoryNameResId = R.string.home_tab_animation),
            HomeCategoryData(categoryNameResId = R.string.home_tab_news),
        )

        _homeCategoryList.emit(homeCategoryDataList)
    }

    fun setMainBannerList() = viewModelScope.launch {
        val mainBannerDataList = listOf(
            VideoData(videoPoster = R.drawable.drama1_poster_image, videoTitle = "드라마1 어쩌고 저쩌고"),
            VideoData(videoPoster = R.drawable.drama2_poster_image, videoTitle = "드라마2 어쩌고 저쩌고"),
            VideoData(videoPoster = R.drawable.drama3_poster_image, videoTitle = "드라마3 어쩌고 저쩌고"),
            VideoData(videoPoster = R.drawable.drama4_poster_image, videoTitle = "드라마4 어쩌고 저쩌고"),
            VideoData(videoPoster = R.drawable.drama5_poster_image, videoTitle = "드라마5 어쩌고 저쩌고"),
            VideoData(videoPoster = R.drawable.drama6_poster_image, videoTitle = "드라마6 어쩌고 저쩌고"),
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
            VideoData(videoPoster = R.drawable.drama1_poster_image),
            VideoData(videoPoster = R.drawable.drama2_poster_image),
            VideoData(videoPoster = R.drawable.drama3_poster_image),
            VideoData(videoPoster = R.drawable.drama4_poster_image),
            VideoData(videoPoster = R.drawable.drama5_poster_image),
            VideoData(videoPoster = R.drawable.drama6_poster_image),
            VideoData(videoPoster = R.drawable.drama7_poster_image),
            VideoData(videoPoster = R.drawable.drama8_poster_image),
            VideoData(videoPoster = R.drawable.drama9_poster_image),
            VideoData(videoPoster = R.drawable.drama10_poster_image)
        ).shuffled()

        _rankingList.emit(rankingDataList)
    }

    fun setOnAirList() = viewModelScope.launch {
        val onAirDataList = listOf(
            VideoData(videoPoster = R.drawable.drama10_poster_image),
            VideoData(videoPoster = R.drawable.drama9_poster_image),
            VideoData(videoPoster = R.drawable.drama8_poster_image),
            VideoData(videoPoster = R.drawable.drama7_poster_image),
            VideoData(videoPoster = R.drawable.drama6_poster_image),
            VideoData(videoPoster = R.drawable.drama5_poster_image),
            VideoData(videoPoster = R.drawable.drama4_poster_image),
            VideoData(videoPoster = R.drawable.drama3_poster_image),
            VideoData(videoPoster = R.drawable.drama2_poster_image),
            VideoData(videoPoster = R.drawable.drama1_poster_image)
        ).shuffled()

        _onAirList.emit(onAirDataList)
    }

    fun getMyInfo() = viewModelScope.launch {
        val myUserId: Long = prefs.getData(USER_ID)?.toLong() ?: 0
        val result = ServicePool.userService.getMyNickName(myUserId)

        if(result.isSuccessful) {
            result.body()?.let {
                _myInfo.emit(it.data?.nickname)
            }
        }
    }

    fun searchUserInfo(searchText: String) = viewModelScope.launch {
        val result = ServicePool.userService.getNickNameList(searchText)

        if(result.isSuccessful) {
            result.body()?.let {
                _searchResultList.emit(it.data?.nicknameList)
            }
        }
    }

}