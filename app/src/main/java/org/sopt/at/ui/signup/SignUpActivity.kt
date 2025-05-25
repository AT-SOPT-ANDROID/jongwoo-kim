package org.sopt.at.ui.signup

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.custom.HeaderLayout
import org.sopt.at.domain.dataSource.SignUpRequest
import org.sopt.at.ui.signup.navigation.SignupNavGraph
import org.sopt.at.ui.signup.screen.rememberSignUpAccountState


class SignUpActivity : ComponentActivity() {
    private val viewModel: SignUpViewModel by viewModels()

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Scaffold(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
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

        lifecycleScope.launch {
            viewModel.signUpSuccess.collect {
                if(it == null) return@collect

                finish()
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
            }
        }

        lifecycleScope.launch {
            viewModel.idIsDuplicated.collect {
                if(it == null) return@collect

                Toast.makeText(applicationContext, resources.getString(R.string.toast_signup_id_duplicated), Toast.LENGTH_SHORT).show()
            }
        }
    }

    @Composable
    fun ContentLayout() {
        navController = rememberNavController()
        val accountState = rememberSignUpAccountState()

        SignupNavGraph(
            navController = navController,
            signUpAccountState = accountState,
            signUpEndCallback = {
                val signUpRequest = SignUpRequest(
                    loginId = accountState.id,
                    nickname = accountState.nickName,
                    password = accountState.pw
                )
                viewModel.signUp(signUpRequest)
            }
        )
    }

}