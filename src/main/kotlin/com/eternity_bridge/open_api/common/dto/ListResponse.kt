package com.eternity_bridge.open_api.common.dto

class ListResponse<T> : CommonResponse() {
    private var dataList: List<T>? = null

    fun setDataList(
        dataList: List<T>
    ) {
        this.dataList = dataList
    }
}