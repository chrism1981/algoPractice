package com.practice.array

class RemoveDuplicate {

    /**
     * 快慢指针法
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
     *[1,1,1,2,2,3,4,5,5]
     */
    fun removeDuplicates(nums: IntArray): Int {
        var slow = 0;
//        for (fast in nums.indices) {
//            if (nums[fast] != nums[slow]) {
//                slow++
//                nums[slow] = nums[fast]// 思路就是，slow只有当遇到一个不相同的数字才移动，并且
//                //改写当前位置的值为新的不同的值，这样就可以保证数组slow左边没有重复的数，不需要管后面是什么
//                //只要遍历完以后，slow把所有的不重复值都写了一遍。
//            }
//        }
        nums.forEach { it->
            if (nums[slow] != it){
                slow ++
                nums[slow] = it
            }
        }
        return slow + 1
    }
}

fun main(){
    val run = RemoveDuplicate()
    val arr = intArrayOf(1,1,2,2,2,3,3,3,4,5,6,6)
    print(" size is " + run.removeDuplicates(arr))
    val arlist = arrayListOf<Int>()
    arlist.addAll(arr.asList())
    print(arlist.toString())

}
