package org.sopt.at.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.custom.HeaderLayout
import org.sopt.at.domain.dataSource.SignInRequest
import org.sopt.at.ui.main.MainActivity
import org.sopt.at.ui.signup.SignUpActivity
import org.sopt.at.util.MyApplication.Companion.LOGIN_ID
import org.sopt.at.util.MyApplication.Companion.PASSWORD
import org.sopt.at.util.MyApplication.Companion.USER_ID
import org.sopt.at.util.MyApplication.Companion.prefs

class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        initObserver()

        setContent {
            Scaffold(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
                topBar = {
                    HeaderLayout(backBtnCallback = { finish() })
                }, content = { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val accountState = rememberLoginAccountState()

                        LoginScreen(
                            loginAccountState = accountState,
                            onLoginClick = {
                                val signInRequest = SignInRequest(loginId = accountState.id, password = accountState.pw)
                                viewModel.signIn(signInRequest)
                            },
                            onSignUpClick = {
                                intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                                startActivity(intent)
                            }
                        )
                    }
                }
            )
        }
    }


    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.signInSuccess.collect {
                if(it == null) return@collect

                prefs.setData(USER_ID, it.userId.toString())
                prefs.setData(LOGIN_ID, viewModel.loginId)
                prefs.setData(PASSWORD, viewModel.password)

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

        lifecycleScope.launch {
            viewModel.signInFail.collect {
                if (it == null) return@collect

                Toast.makeText(applicationContext, resources.getString(R.string.toast_login_fail), Toast.LENGTH_SHORT).show()
            }
        }
    }
}