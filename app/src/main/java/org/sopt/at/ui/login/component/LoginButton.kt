package org.sopt.at.ui.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.ui.login.LoginAccountState

@Composable
fun LoginButton(
    loginAccountState: LoginAccountState,
    onLoginClick: () -> Unit,
) {
    Button(
        onClick = {
            onLoginClick()
        },
        enabled = loginAccountState.isLoginBtnEnable,
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
                text = stringResource(R.string.login_button_text),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    )
}