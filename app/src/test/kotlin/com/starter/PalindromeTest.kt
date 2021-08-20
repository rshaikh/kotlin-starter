package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class PalindromeTest {
    fun isPalindrome(s: String): Boolean {
//        val filteredString = s.filter { it.isLetterOrDigit() }.map {it.toLowerCase()}
//        return filteredString == filteredString.reversed()

        // using two pointers

        var left = 0
        var right = s.length - 1

        while (left < right) {
            while(left < right && !s[left].isLetterOrDigit()) {
                left++
            }
            while(left < right && !s[right].isLetterOrDigit()) {
                right--
            }

            if(s[left].toLowerCase() != s[right].toLowerCase()) {
                return false
            }

            left++
            right--
        }
        return true
    }

    @Test
    internal fun name() {
        isPalindrome("A man, a plan, a canal: Panama") `should equal` true
        isPalindrome("race a car") `should equal` false
    }
}