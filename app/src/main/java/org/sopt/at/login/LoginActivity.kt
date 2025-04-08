package org.sopt.at.login

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import org.sopt.at.my.MyActivity
import org.sopt.at.signup.SignUpActivity
import org.sopt.at.ui.theme.HeaderLayout
import org.sopt.at.util.MyApplication.Companion.prefs
import org.sopt.at.util.noRippleClickable
import org.sopt.at.util.toAnnotatedString

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
        var isLoginBtnEnable by remember { mutableStateOf(false) }
        var shouldShowPassword by remember { mutableStateOf(false) }

        val localFocusManager = LocalFocusManager.current
        val keyboardActions = KeyboardActions(
            onNext = { localFocusManager.moveFocus(FocusDirection.Down) },
            onDone = { localFocusManager.clearFocus() }
        )

        isLoginBtnEnable = idTextValue.isNotEmpty() && pwTextValue.isNotEmpty()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(top = 20.dp, start = 16.dp, end = 16.dp)
        ) {

            // Title
            Text(
                text = resources.getString(R.string.login_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Id TextField
            TextField(
                value = idTextValue,
                onValueChange = { idTextValue = it },
                placeholder = { Text(text = resources.getString(R.string.login_id_placeholder)) },
                singleLine = true,
                shape = RoundedCornerShape(2.dp),
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
                placeholder = { Text(text = resources.getString(R.string.login_pw_placeholder)) },
                singleLine = true,
                shape = RoundedCornerShape(2.dp),
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
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = if(shouldShowPassword) R.drawable.icon_eye_open else R.drawable.icon_eye_close),
                            tint = Color.White,
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
                    if(idTextValue == prefs.getData("ID") && pwTextValue == prefs.getData("PW")) {
                        val intent = Intent(this@LoginActivity, MyActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(applicationContext, resources.getString(R.string.toast_login_fail), Toast.LENGTH_SHORT).show()
                    }
                },
                enabled = isLoginBtnEnable,
                shape = RoundedCornerShape(2.dp),
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
                        text = resources.getString(R.string.login_button_text),
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
                    text = resources.getString(R.string.login_find_id_btn),
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
                    text = resources.getString(R.string.login_find_pw_btn),
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
                    text = resources.getString(R.string.login_signup_btn),
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

            val privacyServiceFormattedText = resources.getString(
                R.string.login_privacy_service_terms,
                "<u>${resources.getString(R.string.login_privacy_service_terms_content_1)}</u>",
                "<u>${resources.getString(R.string.login_privacy_service_terms_content_2)}</u>"
            ).replace("\n", "<br>")

            Text(
                text = Html.fromHtml(privacyServiceFormattedText, Html.FROM_HTML_MODE_LEGACY).toAnnotatedString(),
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

                Log.d("Logd", "id = $id pw = $pw")

                prefs.setData("ID", id)
                prefs.setData("PW", pw)
            }
        }

}