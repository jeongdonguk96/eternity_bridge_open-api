package com.eternity_bridge.open_api.util

import java.text.SimpleDateFormat
import java.util.Date

val formatter = SimpleDateFormat("yyyyMMddHHmmssSSS")

object LogUtil {

    fun generatetrxId(): String {
        val randomNumber = generateRandom4Digit()
        return formatter.format(Date()) + randomNumber
    }

}
