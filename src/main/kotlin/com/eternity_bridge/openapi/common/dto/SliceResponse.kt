package com.eternity_bridge.openapi.common.dto

import org.springframework.data.domain.Slice

class SliceResponse<T>(
    private val valueList: Slice<T>?,
    private val hasNext: Boolean
) : CommonResponse() {
}