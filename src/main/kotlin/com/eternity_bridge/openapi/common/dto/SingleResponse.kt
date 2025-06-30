package com.eternity_bridge.openapi.common.dto

import com.fasterxml.jackson.annotation.JsonProperty

class SingleResponse<T> : CommonResponse() {
    @JsonProperty
    private var data: T? = null

    fun setData(
        data: T
    ) {
        this.data = data
    }
}