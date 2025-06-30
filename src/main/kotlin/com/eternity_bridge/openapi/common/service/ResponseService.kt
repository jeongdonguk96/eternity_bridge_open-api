package com.eternity_bridge.openapi.common.service

import com.eternity_bridge.openapi.common.dto.CommonResponse
import com.eternity_bridge.openapi.common.dto.ListResponse
import com.eternity_bridge.openapi.common.dto.PageResponse
import com.eternity_bridge.openapi.common.dto.SingleResponse
import com.eternity_bridge.openapi.common.dto.SliceResponse
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class ResponseService {

    fun getSuccessResponse(): CommonResponse {
        val response = CommonResponse()
        response.setSuccessResponse()

        return response
    }


    fun getFailResponse(
        exception: Exception
    ): CommonResponse {
        val response = CommonResponse()
        response.setFailResponse(exception)

        return response
    }


    fun <T> getSingleResponse(
        data: T
    ): SingleResponse<T> {
        val response = SingleResponse<T>()
        response.setData(data)
        response.setSuccessResponse()

        return response
    }


    fun <T> getListResponse(
        dataList: List<T>
    ): ListResponse<T> {
        val response = ListResponse<T>()
        response.setDataList(dataList)
        response.setSuccessResponse()

        return response
    }


    fun <T> getPageResponse(
        dataList: Page<T>
    ): PageResponse<T> {
        val response = PageResponse<T>()
        response.setDataList(dataList)
        response.setSuccessResponse()

        return response
    }


    fun <T> getSliceResponse(
        dataList: SliceResponse<T>
    ): SliceResponse<T> {
        dataList.setSuccessResponse()

        return dataList
    }

}