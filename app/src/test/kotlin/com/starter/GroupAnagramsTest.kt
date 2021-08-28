package com.starter

import org.amshove.kluent.`should contain`
import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class GroupAnagramsTest {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        for (s in strs) {
            val sorted = s.toCharArray().sorted().toString()
            if(map[sorted] == null) {
                map[sorted] = mutableListOf(s)
            } else {
                map[sorted]!!.add(s)
            }
        }
        return map.values.toList()
    }

    @Test
    fun name() {
        /*
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
         */

        val input = arrayOf("eat","tea","tan","ate","nat","bat")

        val result = groupAnagrams(input)

        result.size `should equal` 3
        result[0] `should equal` arrayListOf("eat", "tea", "ate")
        result[1] `should equal` arrayListOf("tan", "nat")
        result[2] `should equal` arrayListOf("bat")
    }
}