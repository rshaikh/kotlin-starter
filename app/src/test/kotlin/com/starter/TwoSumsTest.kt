package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class TwoSumsTest {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        // brute force
        /*for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                val complement = target - nums[i]
                if(complement == nums[j]) {
                    return intArrayOf(i, j)
                }
            }
        }
        return emptyArray<Int>().toIntArray()*/

        //Using hashmap
        val map = mutableMapOf<Int, Int>()
        for(i in nums.indices) {
            val complement = target - nums[i]
            if(map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
        return emptyArray<Int>().toIntArray()
    }

    @Test
    internal fun `two sums 1`() {
//        Input: nums = [2,7,11,15], target = 9
        val nums = intArrayOf(2,7,11,15)

        val result = twoSum(nums, 9)

        result.size `should equal` 2
        result[0] `should equal` 0
        result[1] `should equal` 1

    }

    @Test
    internal fun `two sums 2`() {
        val nums = intArrayOf(3,2,4)

        val result = twoSum(nums, 6)

        result.size `should equal` 2
        result[0] `should equal` 1
        result[1] `should equal` 2

    }
}