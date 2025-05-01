package org.sopt.at.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.sopt.at.R
import org.sopt.at.ui.login.LoginActivity
import org.sopt.at.ui.main.MainActivity
import org.sopt.at.ui.my.MyActivity
import org.sopt.at.util.MyApplication.Companion.PREFS_ID_KEY
import org.sopt.at.util.MyApplication.Companion.prefs

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaunchedEffect(Unit) {
                delay(2000)
                val insertedId = prefs.getData(PREFS_ID_KEY)

                val intent = if(insertedId.isNullOrBlank()) {
                    Intent(applicationContext, LoginActivity::class.java)
                } else {
                    Intent(applicationContext, MainActivity::class.java)
                }
                startActivity(intent)
                finish()
            }

            Scaffold(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
            ) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    ContentLayout()
                }
            }
        }
    }

    @Composable
    fun ContentLayout() {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black)
        ) {
            Text(
                text = resources.getString(R.string.splash_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}