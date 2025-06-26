package com.eternity_bridge.openapi.exception.handler

import com.eternity_bridge.openapi.common.dto.CommonResponse
import com.eternity_bridge.openapi.common.service.ResponseService
import com.eternity_bridge.openapi.exception.exception.CommonException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler(
    private val responseService: ResponseService
) {

    @ExceptionHandler(CommonException::class)
    fun handleCommonException(
        exception: CommonException
    ): CommonResponse {
        return responseService.getFailResponse(exception)
    }


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(
        exception: MethodArgumentNotValidException
    ): CommonResponse {
        return responseService.getFailResponse(exception)
    }

}