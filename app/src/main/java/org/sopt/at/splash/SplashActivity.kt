package org.sopt.at.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.login.LoginActivity
import org.sopt.at.my.MyActivity
import org.sopt.at.splash.ui.theme.ATSOPTANDROIDTheme
import org.sopt.at.util.MyApplication.Companion.prefs

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    private var splashHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    ContentLayout()

                    splashHandler.postDelayed({
                        val insertedId = prefs.getData("ID")

                        val intent = if(insertedId.isNullOrBlank()) {
                            Intent(applicationContext, LoginActivity::class.java)
                        } else {
                            Intent(applicationContext, MyActivity::class.java)
                        }
                        startActivity(intent)
                        finish()
                    }, 2000)
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