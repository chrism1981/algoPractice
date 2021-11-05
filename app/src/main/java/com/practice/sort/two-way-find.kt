package com.practice.sort

fun search(nums: IntArray, target: Int): Int {
   /*
    二分法实际上是要减少遍历，这个方法虽然找到了中心点，但是在子数组里仍然是挨个遍历
    var i = nums.size/2
    val index = nums[i]
    if (index == target) return i
    val step = if (index < target) 1 else -1

    while(i>=0 && i <nums.size){
        if(nums[i] == target )
            return i
        i += step
    } */

    /*正经的二分是每次循环重新确立 middle，起点或者终点，每次都是 mid = left + (righ-left)/2
    然后只比较mid和target，left 和right的作用是不断寻找targrt可能出现的子数组，mid < tar -> left = mid+1
    mid > tar -> right = mid - 1
     */

    var left = 0
    var right = nums.size - 1
    while (left <= right){
        val middle = left + (right - left)/2
        val midValue = nums[middle]
        when {
            midValue < target -> {
                left = middle + 1
            }
            midValue > target -> {
                right = middle - 1
            }
            else -> return middle
        }
    }
    return -1
}

fun main(){
    val array = intArrayOf(8,11,12,44,55)
    print(search(array,12))
}