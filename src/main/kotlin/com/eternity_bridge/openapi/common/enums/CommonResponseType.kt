package com.eternity_bridge.openapi.common.enums

enum class CommonResponseType(
    val code: Int,
    val message: String
) {

    SUCCESS(200, "SUCCESS"),
    FAIL(400, "FAIL"),

}