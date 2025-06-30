package com.eternity_bridge.openapi.common.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ListResponse<T> : CommonResponse() {
    @JsonProperty
    private var dataList: List<T>? = null

    fun setDataList(
        dataList: List<T>
    ) {
        this.dataList = dataList
    }
}