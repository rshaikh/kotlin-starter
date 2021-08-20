package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test
    import kotlin.math.min

class FindIntersectionTest {

    /*
        Runtime: 420 ms
        Memory Usage: 39 MB
     */
    private fun findInterSection(nums1: IntArray, nums2: IntArray): IntArray {
        val numsMap1 = mutableMapOf<Int, Int>()
        for(n in nums1) {
            if(numsMap1.containsKey(n)) {
                numsMap1[n] = numsMap1[n]!!.plus(1)
            } else {
                numsMap1[n] = 1
            }
        }

        val numsMap2 = mutableMapOf<Int, Int>()
        for(n in nums2) {
            if(numsMap2.containsKey(n)) {
                numsMap2[n] = numsMap2[n]!!.plus(1)
            } else {
                numsMap2[n] = 1
            }
        }

        var result = mutableListOf<Int>()

        for (key in numsMap1.keys){
            if(numsMap2.containsKey(key)) {
                val min = min(numsMap1[key]!!, numsMap2[key]!!)
                for(i in 0 until min) {
                    result.add(key)
                }
            }
        }

        return result.toIntArray()
    }

    private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        val arr = mutableListOf<Int>()
        nums1.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        nums2.forEach {
            if(map.getOrDefault(it, 0) > 0) {
                arr.add(it)
                map[it] = map[it]!! -1
            }
        }
        return arr.toIntArray()
    }

    @Test
    fun `should return true when brackets are balanced`() {
        val result = findInterSection(intArrayOf(1,2,2,1), intArrayOf(2,2))

        result.size `should equal` 2
        result[0] `should equal` 2
        result[1] `should equal` 2
    }

    @Test
    fun `intersect -- should return true when brackets are balanced`() {
        val result = intersect(intArrayOf(1,2,2,1), intArrayOf(2,2))

        result.size `should equal` 2
        result[0] `should equal` 2
        result[1] `should equal` 2
    }
}