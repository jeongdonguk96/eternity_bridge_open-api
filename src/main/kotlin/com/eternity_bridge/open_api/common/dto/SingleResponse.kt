package com.eternity_bridge.open_api.common.dto

class SingleResponse<T> : CommonResponse() {
    private var data: T? = null

    fun setData(
        data: T
    ) {
        this.data = data
    }
}