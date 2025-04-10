package org.sopt.at.signup

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.sopt.at.R
import org.sopt.at.signup.navigation.SignupNavGraph
import org.sopt.at.ui.HeaderLayout
import org.sopt.at.util.MyApplication.Companion.ID_KEY
import org.sopt.at.util.MyApplication.Companion.PW_KEY

class SignUpActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    private var idValue = ""
    private var pwValue = ""

    private val finishIntent = Intent()

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
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ContentLayout()
                    }
                }
            )
        }
    }

    @Composable
    fun ContentLayout() {
        navController = rememberNavController()

        SignupNavGraph(
            navController = navController,
            idCallback = { id ->
                idValue = id
            },
            pwCallback = { pw ->
                pwValue = pw

                // 필수과제 로직
                finishIntent.putExtra(ID_KEY, idValue)
                finishIntent.putExtra(PW_KEY, pwValue)
                setResult(RESULT_OK, finishIntent)
                finish()
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
            }
        )
    }

}