package org.sopt.at.ui.main

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
import org.sopt.at.util.type.MainNaviType

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var mainScreen by remember { mutableStateOf(MainNaviType.Home) }

            Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                MainHeaderLayout()
            }, content = { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding).background(Color.Black)) {
                    MainScreen(mainScreen, viewModel)
                }
            }, bottomBar = {
                MainBottomBarLayout(naviBtnCallback = { type ->
                    mainScreen = type
                })
            })
        }
    }
}