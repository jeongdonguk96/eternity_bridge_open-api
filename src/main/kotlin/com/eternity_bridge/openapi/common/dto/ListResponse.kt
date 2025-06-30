package com.eternity_bridge.openapi.common.dto

class ListResponse<T> : CommonResponse() {
    var dataList: List<T>? = null

    fun setDataList(
        dataList: List<T>
    ) {
        this.dataList = dataList
    }
}