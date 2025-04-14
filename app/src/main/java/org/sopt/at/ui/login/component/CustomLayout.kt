package org.sopt.at.ui.login.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DividerLine() {
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
}