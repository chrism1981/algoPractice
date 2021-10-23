package com.example.myapplication

/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */


class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        for (i in nums.indices){
            for(j in 0 until i){
                print(" now is i= $i j= $j /\n")
                if(nums[i] + nums[j] == target){
                    result[0] = i
                    result[1] = j
                    return result
                }
            }
        }
        return result
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        for (i in nums.indices){
            for(j in i+1 until nums.size){
                print(" now is i= $i j= $j /\n")
                if(nums[i] + nums[j] == target){
                    result[0] = i
                    result[1] = j
                    return result
                }
            }
        }
        return result
    }

    fun twoSumWithMap(nums: IntArray, target: Int): IntArray{
//        val result = IntArray(2)
        val map = mutableMapOf<Int,Int>()
        map[nums[0]] = 0
        for (i in 1 until  nums.size){
            if(map.contains(target - nums[i])){
//                result[0] = map.getValue(target - nums[i])
//                result[1] = i
//                return result
                return intArrayOf(map[target - nums[i]]!!,i)
            }
            map[nums[i]] = i
            print(" map.size = ${map.size} \n")
        }
        return intArrayOf()
    }
}

fun main() {
    val s = Solution()
    s.twoSumWithMap(intArrayOf(1,4,6,12),10).forEach { r-> print("$r \n") }
}