package com.eternity_bridge.open_api.common.dto

import org.springframework.data.domain.Slice

class SliceResponse<T>(
    private val valueList: Slice<T>?,
    private val hasNext: Boolean
) : CommonResponse() {
}