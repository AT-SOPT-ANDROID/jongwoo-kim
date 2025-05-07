package org.sopt.at.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.at.R
import org.sopt.at.ui.my.MyScreen
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
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.icon_back),
            contentDescription = "back button",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .noRippleClickable {
                    backBtnCallback.invoke()
                }
        )
    }
}

@Composable
fun MainHeaderLayout(showMyScreen: () -> Unit) {
    Row (
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.tving_text_logo),
            contentDescription = "main text icon",
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(R.drawable.icon_connect),
            contentDescription = "connect icon",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable {

                }
        )

        Spacer(modifier = Modifier.size(16.dp))

        Image(
            painter = painterResource(R.drawable.my_icon),
            contentDescription = "my icon",
            modifier = Modifier
                .size(36.dp)
                .noRippleClickable {
                    showMyScreen.invoke()
                }
        )
    }
}