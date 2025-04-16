package org.sopt.at.ui.home.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.data.VideoData
import org.sopt.at.ui.main.MainViewModel

@Composable
fun MainBannerScreen(viewModel: MainViewModel = hiltViewModel()) {
    val mainBannerList by viewModel.mainBannerList.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .height(550.dp)
            .fillMaxWidth(),
    ) {
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            mainBannerList?.let {
                items(it.size) { index ->
                    MainBannerItemLayout(mainBannerData = it[index])
                }
            }
        }
    }
}

@Composable
fun MainBannerItemLayout(mainBannerData: VideoData) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = mainBannerData.videoPoster ?: 0),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(brush = Brush.verticalGradient(listOf(Color.Transparent, Color.Black)), alpha = 0.5f)
                .padding(16.dp)
        ) {
            Text(
                text = mainBannerData.videoTitle ?: "",
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
            )
        }
    }
}