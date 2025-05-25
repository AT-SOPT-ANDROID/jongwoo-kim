package org.sopt.at.ui.search.component

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.isVisible
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.R
import org.sopt.at.ui.main.MainViewModel

private val debounceHandler = Handler(Looper.getMainLooper())
private var debounceRunnable: Runnable? = null
private val debounceDelay = 400L

@Composable
fun SearchTextField(searchDebounceCallback: (String) -> Unit) {
    var searchValue by remember { mutableStateOf("") }

    LaunchedEffect(searchValue) {
        debounceRunnable?.let { debounceHandler.removeCallbacks(it) }
        debounceRunnable = Runnable {
            searchDebounceCallback.invoke(searchValue)
        }
        debounceHandler.postDelayed(debounceRunnable!!, debounceDelay)
    }

    TextField(
        value = searchValue,
        onValueChange = { searchValue = it },
        placeholder = { Text(text = stringResource(R.string.search_placeholder)) },
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
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        modifier = Modifier
            .fillMaxWidth()
    )
}