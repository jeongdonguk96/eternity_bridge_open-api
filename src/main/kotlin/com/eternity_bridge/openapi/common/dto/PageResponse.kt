package com.eternity_bridge.openapi.common.dto

import org.springframework.data.domain.Page

class PageResponse<T> : CommonResponse() {
    var dataList: Page<T>? = null

    fun setDataList(
        dataList: Page<T>
    ) {
        this.dataList = dataList
    }
}