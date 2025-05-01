package org.sopt.at.ui.my

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.ui.my.component.LogoutButton
import org.sopt.at.ui.splash.SplashActivity
import org.sopt.at.util.MyApplication.Companion.PREFS_ID_KEY
import org.sopt.at.util.MyApplication.Companion.prefs

@Composable
fun MyScreen(logoutCallback: () -> Unit) {
    ContentLayout(logoutCallback)
}

@Composable
fun ContentLayout(logoutCallback: () -> Unit) {
    val idValue = prefs.getData(PREFS_ID_KEY).toString()

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

