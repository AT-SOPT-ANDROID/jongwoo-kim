package org.sopt.at.domain.dataSource

data class SignInRequest(
    var loginId: String? = null,
    var password: String? = null
)

data class SignInResponse(
    var success: Boolean? = null,
    var code: String? = null,
    var message: String? = null,
    var data: SignInData? = null
)

data class SignInData(
    var userId: Long? = null,
)