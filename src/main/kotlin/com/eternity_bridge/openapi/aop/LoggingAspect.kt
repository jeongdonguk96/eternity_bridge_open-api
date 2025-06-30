package com.eternity_bridge.openapi.aop

import com.eternity_bridge.openapi.util.LogUtil
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
        val apiName = joinPoint.signature.name
        val trxId = LogUtil.generateTrxId()
        
        MDC.put("trxId", trxId)
        log.info("[$trxId] ========== $apiName START ==========")
    }


    @After("restController()")
    fun AfterAPI(
        joinPoint: JoinPoint
    ) {
        val apiName = joinPoint.signature.name
        val trxId = MDC.get("trxId")

        log.info("[$trxId] ========== $apiName END ==========")
        MDC.clear()
    }
}