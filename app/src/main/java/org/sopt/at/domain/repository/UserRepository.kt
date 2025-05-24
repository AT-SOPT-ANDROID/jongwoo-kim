package org.sopt.at.domain.repository

import org.sopt.at.domain.dataSource.MyNickNameResponse
import org.sopt.at.domain.dataSource.NickNameListResponse
import org.sopt.at.domain.dataSource.SignInRequest
import org.sopt.at.domain.dataSource.SignInResponse
import org.sopt.at.domain.dataSource.SignUpRequest
import org.sopt.at.domain.dataSource.SignUpResponse
import retrofit2.Response

interface UserRepository {
    suspend fun signUpUser(signUpRequest: SignUpRequest): Response<SignUpResponse>
    suspend fun signInUser(signInRequest: SignInRequest): Response<SignInResponse>
    suspend fun getMyNickName(userId: Long): Response<MyNickNameResponse>
    suspend fun getNickNameList(keyword: String): Response<NickNameListResponse>
}