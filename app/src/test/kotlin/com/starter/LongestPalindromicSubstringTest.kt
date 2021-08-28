package com.starter

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

class LongestPalindromicSubstringTest {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return s
//        given expand function is available loop through every character and find the longest string
        var result = s.substring(0, 1)
        for (i in s.indices) {
            var temp = expand(s, i, i)
            if (temp.length > result.length) {
                result = temp
            }
            //now do the same assuming two characters make the center of palindrome
            temp = expand(s, i, i + 1)
            if (temp.length > result.length) {
                result = temp
            }
        }
        return result
    }

    /*
        s -> given string
        start -> index of current char
        end -> same as start in one char case and start + 1 in case of two chars in the middle
        if char at start and end are equal then we have a palindrome
        next we need to expand it, to do that decrement start and increment end and execute loop again while we find same chars
        at both start and end indexes
     */
    private fun expand(s: String, start_: Int, end_: Int): String {
        var start = start_
        var end = end_
        while (start >= 0 && end < s.length && s[start] == s[end]) {
            start--
            end++
        }
        return s.substring(start + 1, end)
    }

    @Test
    fun name() {
        /*
        Input: s = "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
         */

        val input = "babad"

        val result = longestPalindrome(input)

        result shouldEqual "bab"
    }
}