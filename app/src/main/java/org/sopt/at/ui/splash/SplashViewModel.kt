package org.sopt.at.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.domain.dataSource.SignInRequest
import org.sopt.at.di.ServicePool
import org.sopt.at.util.MyApplication.Companion.LOGIN_ID
import org.sopt.at.util.MyApplication.Companion.PASSWORD
import org.sopt.at.util.MyApplication.Companion.prefs
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel(){

    private val _signInSuccess = MutableStateFlow<Unit?>(null)
    val signInSuccess = _signInSuccess.asStateFlow()

    fun autoSignIn() = viewModelScope.launch {
        val loginId = prefs.getData(LOGIN_ID)
        val password = prefs.getData(PASSWORD)

        val signInRequest = SignInRequest(loginId = loginId, password = password)
        val result = ServicePool.userService.signInUser(signInRequest)

        if(result.isSuccessful) {
            result.body()?.let {
                _signInSuccess.emit(Unit)
            }
        }
    }
}