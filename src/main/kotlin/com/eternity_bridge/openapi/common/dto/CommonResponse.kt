package com.eternity_bridge.openapi.common.dto

import com.eternity_bridge.openapi.common.enums.CommonResponseType
import com.eternity_bridge.openapi.exception.code.ValidationErrorCode
import com.eternity_bridge.openapi.exception.exception.CommonException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.slf4j.MDC
import org.springframework.web.bind.MethodArgumentNotValidException

private val log = KotlinLogging.logger {}

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

        val trxId = MDC.get("trxId")
        when (exception) {
            is CommonException -> {
                this.code = exception.errorCode.code
                this.message = exception.errorCode.message
                log.error { "[$trxId] CommonException 발생 - Code: ${this.code}, Message: ${this.message}" }
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
                log.error { "[$trxId] MethodArgumentNotValidException 발생 - Code: ${this.code}, Message: ${this.message}, Field: ${this.validationErrors?.joinToString { it.field }}" }
            }

            else -> {
                this.code = CommonResponseType.FAIL.code
                this.message = exception.message ?: CommonResponseType.FAIL.message
                log.error { "[$trxId] UncheckException 발생 - Exception: ${exception.javaClass.simpleName}, Code: ${this.code}, Message: ${this.message}" }
            }
        }
    }
}