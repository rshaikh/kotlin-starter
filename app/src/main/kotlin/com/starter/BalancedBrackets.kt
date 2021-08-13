package com.starter

import java.util.*

class BalancedBrackets() {
    fun isBalanced(input: String): Boolean {
        val s = Stack<Char>()
        for (i in input) {
            when (i) {
                '(', '{', '[' -> s.push(i)
                else -> {
                    if (s.pop() != getMatchingBracketFor(i)) return false
                }
            }
        }
        return s.isEmpty()
    }

    private fun getMatchingBracketFor(i: Char): Char {
        return when (i) {
            ')' -> '('
            ']' -> '['
            '}' -> '{'
            else -> 'x'
        }
    }

}
