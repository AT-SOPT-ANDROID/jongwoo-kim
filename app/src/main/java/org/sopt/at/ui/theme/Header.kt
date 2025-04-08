package org.sopt.at.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.at.R
import org.sopt.at.util.noRippleClickable

@Composable
fun HeaderLayout(backBtnCallback: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .statusBarsPadding()
            .height(60.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.icon_back),
            contentDescription = "back button",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .noRippleClickable {
                    backBtnCallback.invoke()
                }
        )
    }
}