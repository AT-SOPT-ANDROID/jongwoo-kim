package org.sopt.at.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.domain.dataSource.SignUpData
import org.sopt.at.domain.dataSource.SignUpRequest
import org.sopt.at.di.ServicePool
import org.sopt.at.domain.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private val _signUpSuccess = MutableStateFlow<SignUpData?>(null)
    val signUpSuccess = _signUpSuccess.asStateFlow()

    private val _idIsDuplicated = MutableStateFlow<Unit?>(null)
    val idIsDuplicated = _idIsDuplicated.asStateFlow()


    fun signUp(signUpRequest: SignUpRequest) = viewModelScope.launch {
        val result = userRepository.signUpUser(signUpRequest)

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