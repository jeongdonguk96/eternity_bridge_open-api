package com.eternity_bridge.openapi.common.service

import com.eternity_bridge.openapi.common.AbstractTest
import com.eternity_bridge.openapi.common.enums.CommonResponseType
import com.eternity_bridge.openapi.exception.code.ValidationErrorCode
import com.eternity_bridge.openapi.exception.exception.CommonException
import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.jupiter.api.Test

class ResponseServiceTest : AbstractTest() {

    @Test
    fun `성공 응답 객체가 반환된다`() {
        // given && when
        val result = responseService.getSuccessResponse()

        // then
        assertSoftly {
            it.assertThat(result).isNotNull
            it.assertThat(result.success).isTrue
            it.assertThat(result.code).isEqualTo(CommonResponseType.SUCCESS.code)
            it.assertThat(result.message).isEqualTo(CommonResponseType.SUCCESS.message)
            it.assertThat(result.validationErrors).isNull()
        }
    }

    @Test
    fun `CommonException 발생 시 getFailResponse 매서드가 호출되며 실패 응답 객체가 반환된다`() {
        // given
        val exception = CommonException(ValidationErrorCode.INVALID_PARAMETER)

        // when
        val result = responseService.getFailResponse(exception)

        // then
        assertSoftly {
            it.assertThat(result).isNotNull
            it.assertThat(result.success).isFalse
            it.assertThat(result.code).isEqualTo(ValidationErrorCode.INVALID_PARAMETER.code)
            it.assertThat(result.message).isEqualTo(ValidationErrorCode.INVALID_PARAMETER.message)
            it.assertThat(result.validationErrors).isNull()
        }
    }

}
