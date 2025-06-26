package com.eternity_bridge.openapi.common.dto

import com.eternity_bridge.openapi.common.enums.CommonResponseType
import com.eternity_bridge.openapi.exception.code.ValidationErrorCode
import com.eternity_bridge.openapi.exception.exception.CommonException
import org.springframework.web.bind.MethodArgumentNotValidException

open class CommonResponse {
    var success: Boolean = false
    var code: Int = 0
    var message: String = ""
    var validationErrors: List<ValidationErrorDto>? = null


    open fun setSuccessResponse() {
        this.success = true
        this.code = CommonResponseType.SUCCESS.code
        this.message = CommonResponseType.SUCCESS.message
    }


    open fun setFailResponse(
        exception: Exception
    ) {
        this.success = false

        when (exception) {
            is CommonException -> {
                this.code = exception.errorCode.code
                this.message = exception.errorCode.message
            }

            is MethodArgumentNotValidException -> {
                this.code = ValidationErrorCode.INVALID_PARAMETER.code
                this.message = ValidationErrorCode.INVALID_PARAMETER.message
                this.validationErrors = exception.bindingResult.fieldErrors.map { error ->
                    ValidationErrorDto(
                        message = error.defaultMessage,
                        field = error.field,
                        rejectedValue = error.rejectedValue
                    )
                }
            }

            else -> {
                this.code = CommonResponseType.FAIL.code
                this.message = exception.message ?: CommonResponseType.FAIL.message
            }
        }
    }
}