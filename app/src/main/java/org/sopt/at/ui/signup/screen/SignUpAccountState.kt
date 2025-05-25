package org.sopt.at.ui.signup.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

interface SignUpAccountState {
    var id: String
    var nickName: String
    var pw: String

    val isNextBtnEnableForId: Boolean
    val isNextBtnEnableForNickname: Boolean
    val isNextBtnEnableForPw: Boolean
}

private class SignUpAccountStateImpl() : SignUpAccountState {
    override var id: String by mutableStateOf("")
    override var nickName: String by mutableStateOf("")
    override var pw: String by mutableStateOf("")

    override val isNextBtnEnableForId: Boolean
        get() = id.isNotEmpty()

    override val isNextBtnEnableForNickname: Boolean
        get() = nickName.isNotEmpty()

    override val isNextBtnEnableForPw: Boolean
        get() = pw.isNotEmpty()
}

@Composable
fun rememberSignUpAccountState(): SignUpAccountState = remember { SignUpAccountStateImpl() }