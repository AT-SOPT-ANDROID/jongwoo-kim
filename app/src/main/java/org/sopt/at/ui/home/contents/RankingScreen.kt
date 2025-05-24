package org.sopt.at.ui.home.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.R
import org.sopt.at.domain.dataSource.VideoData
import org.sopt.at.ui.main.MainViewModel

@Composable
fun RankingScreen(viewModel: MainViewModel = hiltViewModel()) {
    val rankingList by viewModel.rankingList.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = stringResource(R.string.home_ranking_screen_title),
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(R.string.home_ranking_screen_sub_title),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
        }

        LazyRow(
            modifier = Modifier
                .height(160.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            rankingList?.let {
                items(it.size) { index ->
                    RankingItemLayout(index, it[index])
                }
            }
        }
    }
}

@Composable
fun RankingItemLayout(index: Int, rankingData: VideoData) {
    Row {
        Text(
            text = (index+1).toString(),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 64.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Bottom)
        )

        Image(
            painter = painterResource(rankingData.videoPoster ?: 0),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .width(120.dp)
                .height(160.dp)
        )
    }
}