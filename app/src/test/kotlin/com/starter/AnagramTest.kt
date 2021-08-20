package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class AnagramTest {

    fun isAnagram(s: String, t: String): Boolean {

        if(s.length != t.length) return false
        val map = mutableMapOf<Char, Int>()
        for(c in s) {
            map[c] = (map[c] ?: 0) + 1
        }

        for(c in t) {
            map[c] = (map[c] ?: 0) - 1
            if(map[c]!! < 0) {
                return false
            }
        }

        return true
    }

    @Test
    internal fun name() {
        isAnagram("anagram", "nagaram") `should equal` true

        isAnagram("rat", "car") `should equal` false
    }
}