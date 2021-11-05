package com.practice.array

class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        var nextIndex = 0
        var numberRemoving = -1
        var removedNumber = nums[0]
        var list = arrayListOf<Int>()
        list.add(0)
        while (list.size < nums.size) {
            var moveToIndex = (nextIndex + k) % nums.size
            numberRemoving = nums[moveToIndex]
            nums[moveToIndex] = removedNumber
            nextIndex = moveToIndex
            if(list.contains(nextIndex))
                nextIndex++
            list.add(nextIndex)
            removedNumber = numberRemoving


            print(" step ${list.size} nexindex is $nextIndex " + nums.contentToString() + "\n")
        }
    }

    fun rotate2(nums: IntArray, k: Int) {
        val n = nums.size
        val newArr = IntArray(n)
        for (i in 0 until n) {
            newArr[(i + k) % n] = nums[i]
            print(newArr.contentToString() + "/\n")

        }
        System.arraycopy(newArr, 0, nums, 0, n)
    }

    fun gcd(x: Int, y: Int): Int {
        print("x is $x  y is $y")
        return if (y > 0) gcd(y, x % y) else x
        // 1-  x=4,y=8 gcd(8,4%8)
        // 2-  x=8 y=4 gcd(4,8%4)
        // 3-  x=4,y=4 gcd(4,4%4)
        // 4-  x=4 y=0 return 4
    }

    fun rotate3(nums: IntArray, ki: Int) {
        var k = ki
        val n = nums.size
        k = k % n
        val count: Int = gcd(k, n)
        for (start in 0 until count) {
            var current = start
            var prev = nums[start]
            print(" start is $start  \n")
            do {
                print("current is $current")
                val next = (current + k) % n
                val temp = nums[next]
                nums[next] = prev
                prev = temp
                current = next
                print("inside do " + nums.contentToString() + " \n")
            } while (start != current)//之前的错误是出现在 偶数的时候，curent+k %n 会出现只有2个结果，0和k自身
        }
    }


}

fun rotate(nums: IntArray, kk: Int):Unit{
    var k = kk % nums.size 
    converseArray(nums, 0,nums.size - 1)
    converseArray(nums, 0, k-1)
    converseArray(nums, k, nums.size - 1)
}

fun converseArray(nums: IntArray, start: Int, ends: Int){
    var startIndex = start
    var endIndex = ends
    while(startIndex < endIndex){
        var tem = nums[startIndex]
        nums[startIndex] = nums[endIndex]
        nums[endIndex] = tem
        startIndex ++
        endIndex --
    }
}

fun rotate2(nums: IntArray, k: Int): Unit {//???该方法是使用额外的数组，不需要在一个数组内交换数据，
    // 空间复杂度高 时间复杂度为  O(2n) = O(n)
    val tmp = IntArray(nums.size) { 0 }

    for ((idx, v) in nums.withIndex()) {
        val newIdx = (idx + k) % nums.size
        tmp[newIdx] = v

        print(" idx is $idx v is $v newIdx is $newIdx \n")
    }

    for ((idx, v) in tmp.withIndex()) {
        nums[idx] = v
    }

}



fun main() {
    val num = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val num2 = intArrayOf(1, 2, 3)
    val num3 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12)

    // RotateArray().rotate3(num, 4)
    rotate2(num, 3)
    print(num.contentToString())
//    RotateArray().rotate(num2, 1)
//    print(num2.contentToString())
//    RotateArray().rotate(num3, 11)
//    print(num3.contentToString())

}