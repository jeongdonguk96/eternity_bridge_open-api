package com.eternity_bridge.openapi.common.dto

data class ValidationErrorDto(
    val field: String,
    val message: String?,
    val rejectedValue: Any?
)
