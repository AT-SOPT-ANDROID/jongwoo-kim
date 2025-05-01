package org.sopt.at.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import org.sopt.at.custom.HomeScrollableTabRow
import org.sopt.at.data.HomeCategoryData
import org.sopt.at.ui.home.tabScreen.AnimeScreen
import org.sopt.at.ui.home.tabScreen.DramaScreen
import org.sopt.at.ui.home.tabScreen.MovieScreen
import org.sopt.at.ui.home.tabScreen.NewsScreen
import org.sopt.at.ui.home.tabScreen.SportsScreen
import org.sopt.at.ui.home.tabScreen.VarietyScreen
import org.sopt.at.ui.main.MainViewModel
import org.sopt.at.util.noRippleClickable

@Composable
fun HomeScreen(viewModel: MainViewModel = hiltViewModel()) {
    viewModel.setHomeCategoryList()
    val homeTabList by viewModel.homeCategoryList.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(pageCount = { homeTabList?.size ?: 0 } )

    var tabTitleList by remember { mutableStateOf<List<Int>>(listOf()) }
    tabTitleList = homeTabList?.map { it.categoryNameResId ?: 0 } ?: listOf()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        HomeTabRowLayout(
            pages = tabTitleList,
            pagerState = pagerState
        )

        HorizontalPager(
            modifier = Modifier.weight(1f),
            userScrollEnabled = false,
            state = pagerState,
        ) { page ->
            when(page) {
                0 -> DramaScreen(viewModel)
                1 -> VarietyScreen(viewModel)
                2 -> MovieScreen(viewModel)
                3 -> SportsScreen(viewModel)
                4 -> AnimeScreen(viewModel)
                5 -> NewsScreen(viewModel)
            }
        }
    }
}

@Composable
fun HomeTabRowLayout(
    pages: List<Int>,
    pagerState: PagerState
) {
    val tabCoroutineScope = rememberCoroutineScope()
    val currentPage = pagerState.currentPage

    HomeScrollableTabRow (
        selectedTabIndex = currentPage,
        indicator = {},
        backgroundColor = Color.Black,
        contentColor = Color.White,
        edgePadding = 0.dp,
    ) {
        pages.forEachIndexed { index, titleResId ->
            val selected = (currentPage == index)

            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(40.dp)
                    .wrapContentWidth()
                    .noRippleClickable {
                        tabCoroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                val titleResId = titleResId

                Text(
                    text = stringResource(titleResId),
                    fontSize = 16.sp,
                    fontWeight = if(selected) FontWeight.Bold else FontWeight.Normal,
                    color = if(selected) Color.White else Color.Gray,
                )
            }
        }
    }
}
