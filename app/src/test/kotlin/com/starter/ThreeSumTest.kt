package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test
import java.util.*

class ThreeSumTest {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        Arrays.sort(nums)
        var i = 0
        while (i < nums.size) {
            /* while (i > 0 && i < nums.size && nums[i] == nums[i - 1]) {
                 i++
             }*/

            if (i == 0 || nums[i] != nums[i - 1]) {
                val twoSum = twoSum(nums, i, result)
            }
//            println("two sums for ${nums[i]} is ${twoSum(nums, nums[i]).toList()}")

            i++
        }
        return result
    }

    fun twoSum(nums: IntArray, i: Int, result: MutableList<List<Int>>) {
        //Using hashmap
        val seen = mutableSetOf<Int>()
        var j = i + 1
        while (j < nums.size) {
            val complement = -nums[i] - nums[j]
            if (seen.contains(complement)) {
                result.add(listOf(nums[i], nums[j], complement))
                while (j + 1 < nums.size && nums[j] == nums[j + 1]) {
                    j++
                }
            }
            seen.add(nums[j])
            j++
        }
    }


    @Test
    fun name() {
        val input = intArrayOf(-1, 0, 1, 2, -1, -4)

        val result = threeSum(input)

        println(result)
        result.size `should equal` 2
    }

    @Test
    fun name1() {
        val input = intArrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)

        val result = threeSum(input)

        println(result)
        result.size `should equal` 2
    }

    @Test
    fun name2() {
        val input = intArrayOf(0, 0, 0)

        val result = threeSum(input)

        println(result)
        result.size `should equal` 1
    }

    @Test
    fun name4() {
        val input = intArrayOf(0, 0, 0, 0)

        val result = threeSum(input)

        println(result)
        result.size `should equal` 1
    }
}

