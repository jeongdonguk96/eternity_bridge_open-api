package com.eternity_bridge.openapi.util

import java.security.SecureRandom

fun generateRandom4Digit(): String {
    val random = SecureRandom()
    val num = (random.nextInt() and 0x7FFFFFFF) % 9000 + 1000;
    return num.toString()
}