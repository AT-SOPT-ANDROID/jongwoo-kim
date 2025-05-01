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
import org.sopt.at.util.type.MainNaviType

@Composable
fun MainBottomBarLayout(
    naviBtnCallback: (MainNaviType) -> Unit
) {
    var selectedNaviType by remember { mutableStateOf(MainNaviType.Home) }

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
                    selectedNaviType = MainNaviType.Home
                    naviBtnCallback.invoke(MainNaviType.Home)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_home),
                contentDescription = "",
                tint = setNaviItemColor(MainNaviType.Home, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_home),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(MainNaviType.Home, selectedNaviType)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = MainNaviType.Shorts
                    naviBtnCallback.invoke(MainNaviType.Shorts)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_shorts),
                contentDescription = "",
                tint = setNaviItemColor(MainNaviType.Shorts, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_shorts),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(MainNaviType.Shorts, selectedNaviType),
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = MainNaviType.Live
                    naviBtnCallback.invoke(MainNaviType.Live)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_live),
                contentDescription = "",
                tint = setNaviItemColor(MainNaviType.Live, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_live),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(MainNaviType.Live, selectedNaviType)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = MainNaviType.Search
                    naviBtnCallback.invoke(MainNaviType.Search)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_search),
                contentDescription = "",
                tint = setNaviItemColor(MainNaviType.Search, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_search),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(MainNaviType.Search, selectedNaviType)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
                .noRippleClickable {
                    selectedNaviType = MainNaviType.History
                    naviBtnCallback.invoke(MainNaviType.History)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_history),
                contentDescription = "",
                tint = setNaviItemColor(MainNaviType.History, selectedNaviType),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(R.string.bottom_navi_history),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = setNaviItemColor(MainNaviType.History, selectedNaviType)
            )
        }
    }
}

private fun setNaviItemColor(currentNaviType: MainNaviType, selectedNaviType: MainNaviType): Color {
    return if (currentNaviType == selectedNaviType) {
        Color.White
    } else {
        Color.Gray
    }
}