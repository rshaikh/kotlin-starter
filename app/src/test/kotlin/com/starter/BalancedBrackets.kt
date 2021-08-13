package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class BalancedBracketsTest {

    @Test
    fun `should return true when brackets are balanced`() {
        val balancedBrackets = BalancedBrackets()

        val result = balancedBrackets.isBalanced("()")

        result `should equal` true
    }

    @Test
    fun `should return false when brackets are not balanced`() {
        val balancedBrackets = BalancedBrackets()

        val result = balancedBrackets.isBalanced("(")

        result `should equal` false
    }

    @Test
    fun `should return true when brackets are balanced - complex example`() {
        val balancedBrackets = BalancedBrackets()

        val result = balancedBrackets.isBalanced("[[[({{}})]]]")

        result `should equal` true
    }

    @Test
    fun `should return false when brackets are not balanced - complex example`() {
        val balancedBrackets = BalancedBrackets()

        val result = balancedBrackets.isBalanced("[[[({{})]]]")

        result `should equal` false
    }
}