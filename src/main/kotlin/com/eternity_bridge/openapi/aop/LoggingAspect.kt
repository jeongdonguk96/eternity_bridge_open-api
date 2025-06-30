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

    @Pointcut("@within(org.springframework.web.bind.annotation.RestControllerAdvice)")
    fun controllerAdvice() {
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
    fun afterAPI(
        joinPoint: JoinPoint
    ) {
        val apiName = joinPoint.signature.name
        val trxId = MDC.get("trxId")

        log.info("[$trxId] ========== $apiName END ==========")
        MDC.clear()
    }


    @Before("controllerAdvice()")
    fun beforeError(
        joinPoint: JoinPoint
    ) {
        val apiName = joinPoint.signature.name
        val trxId = LogUtil.generateTrxId()

        MDC.put("trxId", trxId)
        log.info("[$trxId] ========== $apiName Handler START ==========")
    }


    @After("controllerAdvice()")
    fun afterError(
        joinPoint: JoinPoint
    ) {
        val apiName = joinPoint.signature.name
        val trxId = MDC.get("trxId")

        log.info("[$trxId] ========== $apiName Handler END ==========")
        MDC.clear()
    }
}