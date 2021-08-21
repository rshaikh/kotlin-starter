package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class StrStrTest {
    fun strStr(haystack: String, needle: String): Int {
        if(haystack.isEmpty() && needle.isEmpty()) {
            return 0
        }

        if(needle.isEmpty()) {
            return 0
        }

        if(haystack.isEmpty()) {
            return -1
        }

        val length = haystack.length - 1
        val needleLength = needle.length - 1
        if(needleLength > length) return -1

        for (pointer1 in 0..length) {
            var hayStackIndex = pointer1
            var matched = false
            for (pointer2 in 0..needleLength) {
                if(hayStackIndex > length) return -1
//                val slice = haystack.slice(pointer1..pointer2)
//                if(slice == needle) return pointer1
                if(haystack[hayStackIndex] != needle[pointer2]) {
                    matched = false
                    break
                }
                matched = true
                hayStackIndex++
            }
            if(matched) {
                return pointer1
            }
        }
        return -1
    }
/*
    h e l l o
    i
 */
    @Test
    internal fun name() {
     strStr("hello", "ll") `should equal` 2
     strStr("hello", "o") `should equal` 4
     strStr("aaaaa", "bba") `should equal` -1
     strStr("", "") `should equal` 0
     strStr("a", "") `should equal` 0
     strStr("", "a") `should equal` -1
    }
}