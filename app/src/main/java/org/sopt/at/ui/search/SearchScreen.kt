package org.sopt.at.ui.search

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.custom.theme.Black00
import org.sopt.at.custom.theme.Gray2
import org.sopt.at.custom.theme.SemiBoldText
import org.sopt.at.custom.theme.White
import org.sopt.at.ui.main.MainViewModel
import org.sopt.at.ui.search.component.SearchTextField

@Composable
fun SearchScreen(viewModel: MainViewModel = hiltViewModel()) {
    val searchResultList by viewModel.searchResultList.collectAsStateWithLifecycle()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Black00)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchTextField { searchText ->
            if(searchText.isNotEmpty()) {
                viewModel.searchUserInfo(searchText)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
           items(searchResultList?.size ?: 0) { index ->
               SearchItemLayout(nickName = searchResultList?.get(index) ?: "")
           }
        }
    }
}

@Composable
fun SearchItemLayout(nickName: String) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .height(56.dp)
            .background(Black00)
            .border(1.dp, Gray2)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SemiBoldText(
            text = nickName,
            color = White,
            textSize = 16.sp
        )
    }
}