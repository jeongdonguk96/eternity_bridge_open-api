package com.eternity_bridge.open_api.exception.exception

import com.eternity_bridge.open_api.exception.code.CommonErrorCode
import java.lang.RuntimeException

class CommonException(
    val errorCode: CommonErrorCode
) : RuntimeException(errorCode.message)