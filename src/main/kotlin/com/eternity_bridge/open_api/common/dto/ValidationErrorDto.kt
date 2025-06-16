package com.eternity_bridge.open_api.common.dto

data class ValidationErrorDto(
    val field: String,
    val message: String?,
    val rejectedValue: Any?
)
