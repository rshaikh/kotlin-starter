package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class MoveZerosTest {
    fun moveZeroes(nums: IntArray): Unit {
        var index = 0
        for (i in nums.indices){
            if(nums[i] != 0) {
                nums[index] = nums[i]
                index++
            }
        }
        for (i in index until nums.size) {
            nums[i] = 0
        }
    }

    @Test
    fun `should move zeros`() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        moveZeroes(nums)

        nums.size `should equal` 5
        nums[0] `should equal` 1
        nums[1] `should equal` 3
        nums[2] `should equal` 12
        nums[3] `should equal` 0
        nums[4] `should equal` 0
    }
}