package org.sopt.at.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.at.custom.MainHeaderLayout
import org.sopt.at.ui.main.component.MainBottomBarLayout

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                MainHeaderLayout()
            }, content = { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding).background(Color.Black)) {
                    MainScreen()
                }
            }, bottomBar = {
                MainBottomBarLayout(naviBtnCallback = { type ->

                })
            })
        }
    }
}