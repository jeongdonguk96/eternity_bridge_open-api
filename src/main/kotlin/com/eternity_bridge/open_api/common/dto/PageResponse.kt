package com.eternity_bridge.open_api.common.dto

import org.springframework.data.domain.Page

class PageResponse<T> : CommonResponse() {
    private var dataList: Page<T>? = null

    fun setDataList(
        dataList: Page<T>
    ) {
        this.dataList = dataList
    }
}