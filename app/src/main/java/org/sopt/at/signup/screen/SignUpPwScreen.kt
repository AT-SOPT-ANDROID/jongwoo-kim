package org.sopt.at.signup.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.sopt.at.R
import org.sopt.at.signup.navigation.SignUpScreenRoute


@Composable
fun SignUpPwScreen(
    navController: NavHostController,
    pwCallback: (String) -> Unit
) {
    val context = LocalContext.current
    var pwTextValue by remember { mutableStateOf("") }
    var isNextBtnEnable by remember { mutableStateOf(false) }
    var shouldShowPassword by remember { mutableStateOf(false) }

    isNextBtnEnable = pwTextValue.isNotEmpty()

    Column (
        modifier = Modifier
            .imePadding()
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 12.dp, start = 16.dp, end = 16.dp)
    ) {

        // Title
        Text(
            text = "비밀번호를 입력해주세요",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Pw TextField
        TextField(
            value = pwTextValue,
            onValueChange = { pwTextValue = it },
            placeholder = { Text(text = "비밀번호") },
            singleLine = true,
            shape = RoundedCornerShape(2.dp),
            textStyle = TextStyle(
                color = Color.LightGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            ),
            colors = TextFieldDefaults.colors(
                cursorColor = Color.Gray,

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
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "영문, 숫자, 특수문자(~!@#$%^&*) 조합 8~15자리",
            fontSize = 12.sp,
            color = Color.Gray,
        )

        Spacer(modifier = Modifier.weight(1f))

        // Next Btn
        Button(
            onClick = {
                if(isPwValid(pwTextValue)) {
                    navController.navigate(SignUpScreenRoute.SignUpPwScreen.route)
                    pwCallback.invoke(pwTextValue)
                }
                else Toast.makeText(context, "아이디 생성 조건에 맞지 않습니다.", Toast.LENGTH_SHORT).show()
            },
            enabled = isNextBtnEnable,
            shape = RoundedCornerShape(2.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Black,
                disabledContainerColor = Color.Gray,

                contentColor = Color.White,
                disabledContentColor = Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(1.dp, Color.Gray),
            content = {
                Text(
                    text = "다음",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

fun isPwValid(input: String): Boolean {
    val regex = "^[a-zA-Z0-9~!@#$%^&*]{8,15}$".toRegex()
    return regex.matches(input)
}