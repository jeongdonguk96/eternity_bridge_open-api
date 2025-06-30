package com.eternity_bridge.openapi.common.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.domain.Page

class PageResponse<T> : CommonResponse() {
    @JsonProperty
    private var dataList: Page<T>? = null

    fun setDataList(
        dataList: Page<T>
    ) {
        this.dataList = dataList
    }
}