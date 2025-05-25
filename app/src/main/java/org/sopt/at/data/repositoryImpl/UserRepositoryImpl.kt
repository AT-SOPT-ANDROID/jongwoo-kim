package org.sopt.at.data.repositoryImpl

import org.sopt.at.data.service.UserService
import org.sopt.at.domain.dataSource.MyNickNameResponse
import org.sopt.at.domain.dataSource.NickNameListResponse
import org.sopt.at.domain.dataSource.SignInRequest
import org.sopt.at.domain.dataSource.SignInResponse
import org.sopt.at.domain.dataSource.SignUpRequest
import org.sopt.at.domain.dataSource.SignUpResponse
import org.sopt.at.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
): UserRepository {

    override suspend fun signUpUser(signUpRequest: SignUpRequest): Response<SignUpResponse> {
        return userService.signUpUser(signUpRequest)
    }

    override suspend fun signInUser(signInRequest: SignInRequest): Response<SignInResponse> {
        return userService.signInUser(signInRequest)
    }

    override suspend fun getMyNickName(userId: Long): Response<MyNickNameResponse> {
        return userService.getMyNickName(userId)
    }

    override suspend fun getNickNameList(keyword: String): Response<NickNameListResponse> {
        return userService.getNickNameList(keyword)
    }
}