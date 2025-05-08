package org.sopt.at.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.dataSource.SignInData
import org.sopt.at.dataSource.SignInRequest
import org.sopt.at.dataSource.SignUpData
import org.sopt.at.dataSource.SignUpRequest
import org.sopt.at.di.ServicePool
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _signInSuccess = MutableStateFlow<SignInData?>(null)
    val signInSuccess = _signInSuccess.asStateFlow()

    private val _signInFail = MutableStateFlow<Unit?>(null)
    val signInFail = _signInFail.asStateFlow()

    var loginId = ""
    var password = ""

    fun signIn(signInRequest: SignInRequest) = viewModelScope.launch {
        val result = ServicePool.userService.signInUser(signInRequest)

        if(result.isSuccessful) {
            result.body()?.let {
                loginId = signInRequest.loginId.toString()
                password = signInRequest.password.toString()

                _signInSuccess.emit(it.data)
            }
        } else {
            if(result.body()?.code == "USER_001") {
                _signInFail.emit(Unit)
            }
        }
    }
}