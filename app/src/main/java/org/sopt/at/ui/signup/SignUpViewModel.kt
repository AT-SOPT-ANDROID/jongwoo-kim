package org.sopt.at.ui.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.dataSource.SignUpData
import org.sopt.at.dataSource.SignUpRequest
import org.sopt.at.dataSource.SignUpResponse
import org.sopt.at.di.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel() {

    private val _signUpSuccess = MutableStateFlow<SignUpData?>(null)
    val signUpSuccess = _signUpSuccess.asStateFlow()

    private val _idIsDuplicated = MutableStateFlow<Unit?>(null)
    val idIsDuplicated = _idIsDuplicated.asStateFlow()


    fun signUp(signUpRequest: SignUpRequest) = viewModelScope.launch {
        val result = ServicePool.userService.signUpUser(signUpRequest)

        if(result.isSuccessful) {
            result.body()?.let {
                _signUpSuccess.emit(it.data)
            }
        } else {
            if(result.code() == 409) {
                _idIsDuplicated.emit(Unit)
            }
        }
    }
}