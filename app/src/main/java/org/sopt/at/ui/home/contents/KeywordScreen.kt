package org.sopt.at.ui.home.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.data.KeywordData
import org.sopt.at.ui.main.MainViewModel

@Composable
fun KeywordScreen(viewModel: MainViewModel = hiltViewModel()) {
    val keywordList by viewModel.keywordList.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            keywordList?.let {
                items(it.size) { index ->
                    KeywordItemLayout(keywordData = it[index])
                }
            }
        }
    }
}

@Composable
fun KeywordItemLayout(keywordData: KeywordData) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(80.dp)
            .clip(shape = RoundedCornerShape(4.dp))
            .background(Color.DarkGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.verticalGradient(listOf(Color.Transparent, Color.Black)), alpha = 0.8f)
        ) {
            Image(
                painter = painterResource(id = keywordData.keywordPoster),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(140.dp)
                    .height(60.dp)
                    .align(Alignment.Center)
            )
        }
    }
}