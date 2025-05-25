package org.sopt.at.ui.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.ui.login.LoginAccountState


@Composable
fun LoginIdTF(
    loginAccountState: LoginAccountState,
    keyboardActions: KeyboardActions,
) {
    TextField(
        value = loginAccountState.id,
        onValueChange = { loginAccountState.id = it },
        placeholder = { Text(text = stringResource(R.string.login_id_placeholder)) },
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
}


@Composable
fun LoginPwTF(
    loginAccountState: LoginAccountState,
    keyboardActions: KeyboardActions,
) {
    var shouldShowPassword by remember { mutableStateOf(false) }

    TextField(
        value = loginAccountState.pw,
        onValueChange = { loginAccountState.pw = it },
        placeholder = { Text(text = stringResource(R.string.login_pw_placeholder)) },
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
}