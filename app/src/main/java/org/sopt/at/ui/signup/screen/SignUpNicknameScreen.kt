package org.sopt.at.ui.signup.screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.sopt.at.R
import org.sopt.at.ui.signup.navigation.SignUpScreenRoute

@Composable
fun SignUpNicknameScreen(
    navController: NavHostController,
    signUpAccountState: SignUpAccountState,
) {
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .imePadding()
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 12.dp, start = 16.dp, end = 16.dp)
    ) {

        // Title
        Text(
            text = context.resources.getString(R.string.signup_nickname_title),
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Nickname TextField
        TextField(
            value = signUpAccountState.nickName,
            onValueChange = { signUpAccountState.nickName = it },
            placeholder = { Text(text = context.resources.getString(R.string.signup_nickname_placeholder)) },
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
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = context.resources.getString(R.string.signup_nickname_condition),
            fontSize = 12.sp,
            color = Color.Gray,
        )

        Spacer(modifier = Modifier.weight(1f))

        // Next Btn
        Button(
            onClick = {
                if(isNicknameValid(signUpAccountState.nickName)) {
                    navController.navigate(SignUpScreenRoute.SignUpPwScreen.route)
                }
                else Toast.makeText(context, context.resources.getString(R.string.toast_signup_nickname_fail), Toast.LENGTH_SHORT).show()
            },
            enabled = signUpAccountState.isNextBtnEnableForId,
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
                    text = context.resources.getString(R.string.signup_nickname_next_btn),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
    }



}

fun isNicknameValid(input: String): Boolean {
    val regex = "^[a-zA-Z0-9가-힣]{1,20}$".toRegex()
    return regex.matches(input)
}