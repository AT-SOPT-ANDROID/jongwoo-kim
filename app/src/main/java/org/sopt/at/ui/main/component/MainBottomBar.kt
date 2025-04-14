package org.sopt.at.ui.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.util.noRippleClickable
import org.sopt.at.util.type.HomeNaviType

@Composable
fun MainBottomBarLayout(
    naviBtnCallback: (HomeNaviType) -> Unit
) {
    var selectedNaviType by remember { mutableStateOf(HomeNaviType.Home) }

    Row(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = HomeNaviType.Home
                    naviBtnCallback.invoke(HomeNaviType.Home)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_home),
                contentDescription = "",
                tint = setNaviItemColor(HomeNaviType.Home, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_home),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(HomeNaviType.Home, selectedNaviType)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = HomeNaviType.Shorts
                    naviBtnCallback.invoke(HomeNaviType.Shorts)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_shorts),
                contentDescription = "",
                tint = setNaviItemColor(HomeNaviType.Shorts, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_shorts),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(HomeNaviType.Shorts, selectedNaviType),
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = HomeNaviType.Live
                    naviBtnCallback.invoke(HomeNaviType.Live)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_live),
                contentDescription = "",
                tint = setNaviItemColor(HomeNaviType.Live, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_live),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(HomeNaviType.Live, selectedNaviType)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = HomeNaviType.Search
                    naviBtnCallback.invoke(HomeNaviType.Search)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_search),
                contentDescription = "",
                tint = setNaviItemColor(HomeNaviType.Search, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_search),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(HomeNaviType.Search, selectedNaviType)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = HomeNaviType.History
                    naviBtnCallback.invoke(HomeNaviType.History)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_history),
                contentDescription = "",
                tint = setNaviItemColor(HomeNaviType.History, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_history),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(HomeNaviType.History, selectedNaviType)
            )
        }
    }
}

private fun setNaviItemColor(currentNaviType: HomeNaviType, selectedNaviType: HomeNaviType): Color {
    return if (currentNaviType == selectedNaviType) {
        Color.White
    } else {
        Color.Gray
    }
}