package org.sopt.at.ui.my

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.ui.my.component.LogoutButton
import org.sopt.at.ui.splash.SplashActivity
import org.sopt.at.custom.HeaderLayout
import org.sopt.at.util.MyApplication.Companion.PREFS_ID_KEY
import org.sopt.at.util.MyApplication.Companion.prefs

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize().background(Color.Black),
                topBar = {
                    HeaderLayout(backBtnCallback = {
                        onBackPressedDispatcher.onBackPressed()
                    })
                }, content = { innerPadding ->
                    Box(modifier = Modifier.background(Color.Black).padding(innerPadding)) {
                        ContentLayout()
                    }
                }
            )
        }
    }

    @Composable
    fun ContentLayout() {
        val idValue = prefs.getData(PREFS_ID_KEY).toString()

        Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)) {
            Text(
                text = idValue,
                fontSize = 24.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            LogoutButton(logoutOnClick = { logout() })
        }
    }

    private fun logout() {
        prefs.clearAll()
        finishAndRestart()
    }

    private fun finishAndRestart() {
        val intent = Intent(applicationContext, SplashActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }


}