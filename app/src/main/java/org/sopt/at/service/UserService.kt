package org.sopt.at.service

import org.sopt.at.dataSource.MyNickNameResponse
import org.sopt.at.dataSource.NickNameListResponse
import org.sopt.at.dataSource.SignUpRequest
import org.sopt.at.dataSource.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UserService {
    @GET("/api/v1/auth/signup")
    fun signUpUser(@Body signUpRequest: SignUpRequest): Call<SignUpResponse>

    @GET("/api/v1/auth/signin")
    fun signInUser(@Query("loginId") loginId: String, @Query("password") password: String): Call<SignUpResponse>

    @GET("/api/v1/users/me")
    fun getMyNickName(@Header("userId") userId: Long): Call<MyNickNameResponse>

    @GET("/api/v1/users/nickname")
    fun getNickNameList(@Query("keyword") keyword: String): Call<NickNameListResponse>
}