package org.sopt.at.ui.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import org.sopt.at.domain.dataSource.BottomBarData
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
        val bottomBarItems = listOf(
            BottomBarData(MainNaviType.Home, R.drawable.icon_home, R.string.bottom_navi_home),
            BottomBarData(MainNaviType.Shorts, R.drawable.icon_shorts, R.string.bottom_navi_shorts),
            BottomBarData(MainNaviType.Live, R.drawable.icon_live, R.string.bottom_navi_live),
            BottomBarData(MainNaviType.Search, R.drawable.icon_search, R.string.bottom_navi_search),
            BottomBarData(MainNaviType.History, R.drawable.icon_history, R.string.bottom_navi_history)
        )

        bottomBarItems.forEach { (naviType, iconRes, titleRes) ->
            BottomNavItem(
                naviType = naviType,
                iconRes = iconRes,
                textRes = titleRes,
                selectedNaviType = selectedNaviType,
                onClick = {
                    selectedNaviType = naviType
                    naviBtnCallback.invoke(naviType)
                }
            )
        }
    }
}

@Composable
private fun RowScope.BottomNavItem(
    naviType: MainNaviType,
    iconRes: Int,
    textRes: Int,
    selectedNaviType: MainNaviType,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .padding(top = 8.dp)
            .noRippleClickable(onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            tint = setNaviItemColor(naviType, selectedNaviType),
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = stringResource(textRes),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = setNaviItemColor(naviType, selectedNaviType)
        )
    }
}

private fun setNaviItemColor(currentNaviType: MainNaviType, selectedNaviType: MainNaviType): Color {
    return if (currentNaviType == selectedNaviType) {
        Color.White
    } else {
        Color.Gray
    }
}