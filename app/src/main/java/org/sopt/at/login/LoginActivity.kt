package org.sopt.at.login

import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.signup.SignUpActivity
import org.sopt.at.ui.theme.HeaderLayout
import org.sopt.at.util.noRippleClickable
import org.sopt.at.util.toAnnotatedString

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Scaffold(modifier = Modifier.fillMaxSize().background(Color.Black),
                topBar = {
                    HeaderLayout(backBtnCallback = { finish() })
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
        var idTextValue by remember { mutableStateOf("") }
        var pwTextValue by remember { mutableStateOf("") }
        var isLoginBtnAvailable by remember { mutableStateOf(false) }
        var shouldShowPassword by remember { mutableStateOf(false) }

        val localFocusManager = LocalFocusManager.current
        val keyboardActions = KeyboardActions(
            onNext = { localFocusManager.moveFocus(FocusDirection.Down) },
            onDone = { localFocusManager.clearFocus() }
        )

        isLoginBtnAvailable = idTextValue.isNotEmpty() && pwTextValue.isNotEmpty()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(top = 20.dp, start = 16.dp, end = 16.dp)
        ) {

            // Title
            Text(
                text = "TVING ID 로그인",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Id TextField
            TextField(
                value = idTextValue,
                onValueChange = { idTextValue = it },
                placeholder = { Text(text = "아이디") },
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.LightGray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                colors = TextFieldDefaults.colors(
                    cursorColor = Color.LightGray,

                    focusedTextColor = Color.LightGray,
                    unfocusedTextColor = Color.LightGray,

                    focusedContainerColor = Color.DarkGray,
                    unfocusedContainerColor = Color.DarkGray,

                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray
                ),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = keyboardActions,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Pw TextField
            TextField(
                value = pwTextValue,
                onValueChange = { pwTextValue = it },
                placeholder = { Text(text = "비밀번호") },
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.LightGray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                colors = TextFieldDefaults.colors(
                    cursorColor = Color.LightGray,

                    focusedTextColor = Color.LightGray,
                    unfocusedTextColor = Color.LightGray,

                    focusedContainerColor = Color.DarkGray,
                    unfocusedContainerColor = Color.DarkGray,

                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray
                ),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            shouldShowPassword = !shouldShowPassword
                        },
                        modifier = Modifier.size(12.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = if(shouldShowPassword) R.drawable.icon_eye_open else R.drawable.icon_eye_close),
                            contentDescription = "Password Toggle"
                        )
                    }
                },
                visualTransformation =
                    if(shouldShowPassword) VisualTransformation.None
                    else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password, imeAction = ImeAction.Done),
                keyboardActions = keyboardActions,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            Button(
                onClick = {

                },
                enabled = isLoginBtnAvailable,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Cyan,
                    disabledContainerColor = Color.Gray,

                    contentColor = Color.White,
                    disabledContentColor = Color.LightGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                content = {
                    Text(
                        text = "로그인하기",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "아이디 찾기",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.LightGray,
                    modifier = Modifier
                        .noRippleClickable {
                            //TODO 아이디 찾기 로직
                        }
                )

                // Divider Line 1
                Box(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(1.dp)
                            .height(20.dp)
                            .background(Color.Gray)
                    )
                }

                Text(
                    text = "비밀번호 찾기",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.LightGray,
                    modifier = Modifier
                        .noRippleClickable {
                            //TODO 비밀번호 찾기 로직
                        }
                )

                // Divider Line 2
                Box(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(1.dp)
                            .height(20.dp)
                            .background(Color.Gray)
                    )
                }

                Text(
                    text = "회원가입",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.LightGray,
                    modifier = Modifier
                        .noRippleClickable {
                            intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                            fromSignUpActivityResult.launch(intent)
                        }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = Html.fromHtml("이 사이트는 Google reCAPTCHA로 보호되며,\n<u>Google 개인정보 처리방침</u>과 <u>서비스약관</u>이 적용됩니다.", Html.FROM_HTML_MODE_LEGACY).toAnnotatedString(),
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }

    private val fromSignUpActivityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val id = data?.getStringExtra("ID") ?: ""
                val pw = data?.getStringExtra("PW") ?: ""



            }
        }

}