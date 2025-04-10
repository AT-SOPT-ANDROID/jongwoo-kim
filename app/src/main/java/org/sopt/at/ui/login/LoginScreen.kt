package org.sopt.at.ui.login

import android.text.Html
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
import androidx.compose.ui.res.stringResource
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
import org.sopt.at.ui.login.component.DividerLine
import org.sopt.at.ui.login.component.LoginButton
import org.sopt.at.ui.login.component.LoginIdTF
import org.sopt.at.ui.login.component.LoginPwTF
import org.sopt.at.util.noRippleClickable
import org.sopt.at.util.toAnnotatedString

@Composable
fun LoginScreen(
    loginAccountState: LoginAccountState,
    onLoginClick:() -> Unit,
    onSignUpClick:() -> Unit
) {
    val localFocusManager = LocalFocusManager.current
    val keyboardActions = KeyboardActions(
        onNext = { localFocusManager.moveFocus(FocusDirection.Down) },
        onDone = { localFocusManager.clearFocus() }
    )

    val privacyServiceFormattedText = stringResource(
        R.string.login_privacy_service_terms,
        "<u>${stringResource(R.string.login_privacy_service_terms_content_1)}</u>",
        "<u>${stringResource(R.string.login_privacy_service_terms_content_2)}</u>"
    ).replace("\n", "<br>")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
    ) {

        // Title
        Text(
            text = stringResource(R.string.login_title),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        LoginIdTF(loginAccountState, keyboardActions)

        Spacer(modifier = Modifier.height(8.dp))

        LoginPwTF(loginAccountState, keyboardActions)

        Spacer(modifier = Modifier.height(24.dp))

        LoginButton(loginAccountState, onLoginClick)

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.login_find_id_btn),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.LightGray,
                modifier = Modifier
                    .noRippleClickable {
                        //TODO 아이디 찾기 로직
                    }
            )

            DividerLine()

            Text(
                text = stringResource(R.string.login_find_pw_btn),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.LightGray,
                modifier = Modifier
                    .noRippleClickable {
                        //TODO 비밀번호 찾기 로직
                    }
            )

            DividerLine()

            Text(
                text = stringResource(R.string.login_signup_btn),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.LightGray,
                modifier = Modifier
                    .noRippleClickable {
                        onSignUpClick()
                    }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

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