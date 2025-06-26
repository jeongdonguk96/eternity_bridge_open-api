package com.eternity_bridge.openapi.exception.exception

import com.eternity_bridge.openapi.exception.code.CommonErrorCode
import java.lang.RuntimeException

class CommonException(
    val errorCode: CommonErrorCode
) : RuntimeException(errorCode.message)