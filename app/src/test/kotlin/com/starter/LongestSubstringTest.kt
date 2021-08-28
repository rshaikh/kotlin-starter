package com.starter

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test
import kotlin.math.max

class LongestSubstringTest {
    //Using temp string
    /*fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) return 0
        var result = ""
        for (i in s.indices) {
            var tempResult = ""
            for (j  in i until s.length) {
                if(!tempResult.contains(s[j])) {
                    tempResult += s[j]
                } else break
            }
            if(tempResult.length > result.length) {
                result = tempResult
            }
        }
        return result.length
    }*/

    //Replacing temp string with hashset
    /*fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) return 0
        var result = 0
        for (i in s.indices) {
            var tempResult = mutableSetOf<Char>()
            for (j  in i until s.length) {
                if(!tempResult.contains(s[j])) {
                    tempResult.add(s[j])
                } else break
            }
            if(tempResult.size > result) {
                result = tempResult.size
            }
        }
        return result
    }*/

    // Using just one loop
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) return 0
        var result = 0
        var aPointer = 0
        var bPointer = 0
        val seen = mutableSetOf<Char>()

        while (bPointer < s.length) {
            if(!seen.contains(s[bPointer])) {
                seen.add(s[bPointer])
                result = max(result, seen.size)
                bPointer++
            } else {
                seen.remove(s[aPointer])
                aPointer++
            }
        }
        return result
    }

    @Test
    fun shouldReturn0ForEmptyString() {
        val input = ""

        val result = lengthOfLongestSubstring(input)
        result shouldEqual 0
    }

    @Test
    fun name() {
        /*
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
         */

        val input = "abcabcbb"

        val result = lengthOfLongestSubstring(input)
        result shouldEqual 3
    }

    @Test
    fun name1() {
        /*
        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
         */

        val input = "bbbbb"

        val result = lengthOfLongestSubstring(input)
        result shouldEqual 1
    }
    @Test
    fun name2() {
        /*
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

         */

        val input = "pwwkew"

        val result = lengthOfLongestSubstring(input)
        result shouldEqual 3
    }
}