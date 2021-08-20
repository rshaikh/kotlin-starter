package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class FirstUniqueChar {
    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char, Int>()

        for (c in s) {
            println(c)
            map[c] = (map[c] ?: 0) + 1
        }
        println(map)
        for (c in s) {
            if(map[c] == 1) {
                return s.indexOf(c)
            }
        }

        return -1
    }

    @Test
    internal fun name() {
        firstUniqChar("loveleetcode") `should equal` 2
    }
}