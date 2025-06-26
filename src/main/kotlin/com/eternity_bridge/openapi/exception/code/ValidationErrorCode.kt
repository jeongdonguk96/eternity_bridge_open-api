package com.eternity_bridge.openapi.exception.code

enum class ValidationErrorCode(
    override var code: Int,
    override var message: String,
) : CommonErrorCode {
    INVALID_PARAMETER(400, "파라미터 검증에 실패했습니다."),
}