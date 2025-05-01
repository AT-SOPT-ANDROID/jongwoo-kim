package org.sopt.at.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.sopt.at.R
import org.sopt.at.custom.HeaderLayout
import org.sopt.at.ui.main.MainActivity
import org.sopt.at.ui.signup.SignUpActivity
import org.sopt.at.util.MyApplication.Companion.ID_KEY
import org.sopt.at.util.MyApplication.Companion.PREFS_ID_KEY
import org.sopt.at.util.MyApplication.Companion.PREFS_PW_KEY
import org.sopt.at.util.MyApplication.Companion.PW_KEY
import org.sopt.at.util.MyApplication.Companion.prefs

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Scaffold(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
                topBar = {
                    HeaderLayout(backBtnCallback = { finish() })
                }, content = { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val accountState = rememberLoginAccountState()
                        val fromSignUpActivityResult = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                            if (result.resultCode == RESULT_OK) {
                                val data: Intent? = result.data
                                val id = data?.getStringExtra(ID_KEY) ?: ""
                                val pw = data?.getStringExtra(PW_KEY) ?: ""

                                prefs.setData(PREFS_ID_KEY, id)
                                prefs.setData(PREFS_PW_KEY, pw)
                            }
                        }

                        LoginScreen(
                            loginAccountState = accountState,
                            onLoginClick = {
                                if(accountState.id == prefs.getData(PREFS_ID_KEY) && accountState.pw == prefs.getData(PREFS_PW_KEY)) {
                                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(applicationContext, resources.getString(R.string.toast_login_fail), Toast.LENGTH_SHORT).show()
                                }
                            },
                            onSignUpClick = {
                                intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                                fromSignUpActivityResult.launch(intent)
                            }
                        )
                    }
                }
            )
        }
    }
}