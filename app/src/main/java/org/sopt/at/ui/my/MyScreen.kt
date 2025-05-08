package org.sopt.at.ui.my

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.ui.my.component.LogoutButton
import org.sopt.at.util.MyApplication.Companion.LOGIN_ID
import org.sopt.at.util.MyApplication.Companion.prefs

@Composable
fun MyScreen(logoutCallback: () -> Unit, closeMyScreen: () -> Unit) {
    BackHandler {
        closeMyScreen.invoke()
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        ContentLayout(logoutCallback)
    }
}

@Composable
fun ContentLayout(logoutCallback: () -> Unit) {
    val idValue = prefs.getData(LOGIN_ID).toString()

    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)) {
        Text(
            text = idValue,
            fontSize = 24.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        LogoutButton(logoutOnClick = {
            logoutCallback.invoke()
        })
    }
}

