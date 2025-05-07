package org.sopt.at.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.at.custom.MainHeaderLayout
import org.sopt.at.ui.main.component.MainBottomBarLayout
import org.sopt.at.ui.my.MyScreen
import org.sopt.at.ui.splash.SplashActivity
import org.sopt.at.util.MyApplication.Companion.prefs
import org.sopt.at.util.type.MainNaviType

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var mainScreen by remember { mutableStateOf(MainNaviType.Home) }
            var showMyScreen by remember { mutableStateOf(false) }

            Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                MainHeaderLayout {
                    showMyScreen = true
                }
            }, content = { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding).background(Color.Black)) {
                    MainScreen(mainScreen, viewModel)
                }
            }, bottomBar = {
                MainBottomBarLayout(naviBtnCallback = { type ->
                    mainScreen = type
                })
            })

            if (showMyScreen) {
                MyScreen(logoutCallback = {
                    logout()
                }, closeMyScreen = {
                    showMyScreen = false
                })
            }
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