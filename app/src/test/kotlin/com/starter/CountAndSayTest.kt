package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class CountAndSayTest {

    fun countAndSay(n: Int): String {
        if (n == 1) return "1"
        if (n == 2) return "11"
        var s = "11"

        for (i in 3..n) {
            var counter = 1
            s = "$s&"
            var t = ""
            for(j in 1 until s.length) {
                if(s[j-1] != s[j]) {
                    t = t + counter.toString() + s[j-1]
                    counter = 1
                } else {
                    counter++
                }
            }
            s = t
        }

        return s
    }

    @Test
    internal fun name() {
        countAndSay(1) `should equal` "1"
        countAndSay(2) `should equal` "11"
        countAndSay(3) `should equal` "21"
        countAndSay(4) `should equal` "1211"
        countAndSay(5) `should equal` "111221"
    }
}