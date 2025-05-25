package org.sopt.at.domain.dataSource

data class MyNickNameResponse (
    var success: Boolean? = null,
    var code: String? = null,
    var message: String? = null,
    var data: MyNickNameData? = null
)

data class MyNickNameData (
    var nickname: String? = null
)