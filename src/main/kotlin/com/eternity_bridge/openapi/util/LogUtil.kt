package com.eternity_bridge.openapi.util

import java.text.SimpleDateFormat
import java.util.Date

val formatter = SimpleDateFormat("yyyyMMddHHmmssSSS")

object LogUtil {

    fun generateTrxId(): String {
        val randomNumber = generateRandom4Digit()
        return formatter.format(Date()) + randomNumber
    }

}
