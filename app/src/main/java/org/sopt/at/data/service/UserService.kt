package org.sopt.at.data.service

import org.sopt.at.domain.dataSource.MyNickNameResponse
import org.sopt.at.domain.dataSource.NickNameListResponse
import org.sopt.at.domain.dataSource.SignInRequest
import org.sopt.at.domain.dataSource.SignInResponse
import org.sopt.at.domain.dataSource.SignUpRequest
import org.sopt.at.domain.dataSource.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @POST("api/v1/auth/signup")
    suspend fun signUpUser(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>

    @POST("api/v1/auth/signin")
    suspend fun signInUser(@Body signInRequest: SignInRequest): Response<SignInResponse>

    @GET("api/v1/users/me")
    suspend fun getMyNickName(@Header("userId") userId: Long): Response<MyNickNameResponse>

    @GET("api/v1/users")
    suspend fun getNickNameList(@Query("keyword") keyword: String): Response<NickNameListResponse>
}