package com.eternity_bridge.open_api.common.enums

enum class CommonResponseType(
    val code: Int,
    val message: String
) {

    SUCCESS(200, "SUCCESS"),
    FAIL(400, "FAIL"),

}