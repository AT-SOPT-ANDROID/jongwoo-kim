package org.sopt.at.domain.dataSource

data class SignUpRequest(
    var loginId: String? = null,
    var password: String? = null,
    var nickname: String? = null
)

data class SignUpResponse(
    var success: Boolean? = null,
    var code: String? = null,
    var message: String? = null,
    var data: SignUpData? = null
)

data class SignUpData(
    var userId: Long? = null,
    var nickname: String? = null
)