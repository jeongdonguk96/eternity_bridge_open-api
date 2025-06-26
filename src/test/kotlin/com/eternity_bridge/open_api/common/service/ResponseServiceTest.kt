package com.eternity_bridge.open_api.common.service

import com.eternity_bridge.open_api.common.AbstractTest
import com.eternity_bridge.open_api.common.enums.CommonResponseType
import com.eternity_bridge.open_api.exception.code.ValidationErrorCode
import com.eternity_bridge.open_api.exception.exception.CommonException
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ResponseServiceTest : AbstractTest() {

    @Test
    fun `성공 응답 객체가 반환된다`() {
        // given && when
        val result = responseService.getSuccessResponse()

        // then
        assertNotNull(result)
        assertTrue(result.success)
        assertEquals(CommonResponseType.SUCCESS.code, result.code)
        assertEquals(CommonResponseType.SUCCESS.message, result.message)
        assertNull(result.validationErrors)
    }

    @Test
    fun `CommonException 발생 시 getFailResponse 매서드가 호출되며 실패 응답 객체가 반환된다`() {
        // given
        val exception = CommonException(ValidationErrorCode.INVALID_PARAMETER)

        // when
        val result = responseService.getFailResponse(exception)

        // then
        assertNotNull(result)
        assertFalse(result.success)
        assertEquals(ValidationErrorCode.INVALID_PARAMETER.code, result.code)
        assertEquals(ValidationErrorCode.INVALID_PARAMETER.message, result.message)
        assertNull(result.validationErrors)
    }

}
