package org.sopt.at.domain.dataSource

data class NickNameListResponse (
    var success: Boolean? = null,
    var code: String? = null,
    var message: String? = null,
    var data: NickNameListData? = null
)

data class NickNameListData (
    var nicknameList: List<String>? = null
)