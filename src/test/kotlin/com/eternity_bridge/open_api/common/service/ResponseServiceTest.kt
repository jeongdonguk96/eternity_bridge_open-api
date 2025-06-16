package com.eternity_bridge.open_api.common.service

import com.eternity_bridge.open_api.common.enums.CommonResponseType
import com.eternity_bridge.open_api.exception.code.ValidationErrorCode
import com.eternity_bridge.open_api.exception.exception.CommonException
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest
class ResponseServiceTest(
    @Autowired private val responseService: ResponseService
) : FunSpec(){

    init {
        test("getSuccessResponse 매서드가 호출되며 성공 응답 객체가 반환된다") {
            val result = responseService.getSuccessResponse()

            result shouldNotBe null
            result.success shouldBe true
            result.code shouldBe CommonResponseType.SUCCESS.code
            result.message shouldBe CommonResponseType.SUCCESS.message
            result.validationErrors shouldBe null
        }


        test("CommonException 발생 시 getFailResponse 매서드가 호출되며 실패 응답 객체가 반환된다.") {
            val exception = CommonException(ValidationErrorCode.INVALID_PARAMETER)
            val result = responseService.getFailResponse(exception)

            result shouldNotBe null
            result.success shouldBe false
            result.code shouldBe ValidationErrorCode.INVALID_PARAMETER.code
            result.message shouldBe ValidationErrorCode.INVALID_PARAMETER.message
            result.validationErrors shouldBe null
        }
    }

}