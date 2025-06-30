package com.eternity_bridge.openapi.common.dto

class SingleResponse<T> : CommonResponse() {
    var data: T? = null

    fun setData(
        data: T
    ) {
        this.data = data
    }
}