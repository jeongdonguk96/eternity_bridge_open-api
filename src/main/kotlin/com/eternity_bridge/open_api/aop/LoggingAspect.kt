package com.eternity_bridge.open_api.aop

import com.eternity_bridge.open_api.util.LogUtil
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAspect {

    private val log = LoggerFactory.getLogger(LoggingAspect::class.java)


    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    fun restController() {
    }


    @Before("restController()")
    fun beforeAPI(
        joinPoint: JoinPoint
    ) {
        val apiName = joinPoint.getSignature().getName()
        val trxId = LogUtil.generatetrxId()

        // MDC: 스레드-세이프한 로깅 컨텍스트
        MDC.put("trxId", trxId)
        log.info("[{}] ========== {} START ==========", trxId, apiName)
    }


    @After("restController()")
    fun AfterAPI(
        joinPoint: JoinPoint
    ) {
        val apiName = joinPoint.getSignature().getName()
        val trxId = MDC.get("trxId")

        log.info("[{}] ========== {} END ==========", trxId, apiName)
        log.info("")

        MDC.clear()
    }
}