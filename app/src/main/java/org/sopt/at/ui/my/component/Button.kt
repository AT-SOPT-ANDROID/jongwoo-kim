package org.sopt.at.ui.my.component

import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import org.sopt.at.R

@Composable
fun LogoutButton(
    logoutOnClick: () -> Unit
) {
    Button(
        onClick = {
            logoutOnClick()
        },
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
            Text(text = stringResource(R.string.my_logout_btn))
        }
    )
}