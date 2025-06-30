package com.eternity_bridge.openapi.common.dto

import org.springframework.data.domain.Slice

class SliceResponse<T>(
    val valueList: Slice<T>?,
    val hasNext: Boolean
) : CommonResponse() {
}