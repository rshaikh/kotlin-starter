package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class MyAtoI {

    fun myAtoi(s: String): Int {
        var newInput = s.trimStart()
        if(newInput.isNotEmpty() && newInput[0].isLetter()) return 0
        var sign = 1
        if(newInput.startsWith("-+")) {
            return 0
        }
        if(newInput.startsWith("-")) {
            sign = -1
            newInput = newInput.slice(1 until newInput.length)
        }

        if(newInput.startsWith("+")) {
            sign = 1
            newInput = newInput.slice(1 until newInput.length)
        }

        var result = 0

        for (c in newInput) {
            if(c.isDigit()) {
                if(result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && Character.getNumericValue(c) > 7)) {
                    return if(sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
                }
                result = (result * 10) + Character.getNumericValue(c)
            }
            if(!c.isDigit()) {
                break
            }
        }

        return result * sign
    }

    @Test
    internal fun name() {
        myAtoi("42") `should equal` 42
        myAtoi("   42") `should equal` 42
        myAtoi("   -42") `should equal` -42
        myAtoi("4193 with words") `should equal` 4193
        myAtoi("words and 987") `should equal` 0
        myAtoi("-91283472332") `should equal` -2147483648
        myAtoi("+1") `should equal` 1
        myAtoi("-+12") `should equal` 0
        myAtoi("21474836460") `should equal` 2147483647
        myAtoi("2147483648") `should equal` 2147483647
    }
}