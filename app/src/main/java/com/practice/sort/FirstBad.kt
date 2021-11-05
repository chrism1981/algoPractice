package com.practice.sort

import java.util.concurrent.BlockingDeque

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/96/sorting-and-searching/774/
 */

fun firstBadVersion(n: Int) : Int {
    var left = 1
    var right = n
    var result = -1
//    var mid = (right - left)/2
    while (left <= right){// <时候，n=2 会出现 第一次 mid=1-> false；ssksk 然后 left = right = 2 ，2不进入循环无法被判断，result= defalt
        var mid = left + (right - left)/2  // !!!! right -left /2 是不行的，比如 mid = (right:7- left:4)/2 = 1 在右半段会出现mid 出现在left左边，所以要加上left

        if(isBadVersion(mid)){//左移动,向左边找到的最后一个true一定是the first bad
            right = mid - 1
            result = mid
//            mid = left + (right - left)/2
        }else{
            left = mid + 1
//            mid = left + (right - left)/2
        }
    }
    return result
}

fun isBadVersion(int: Int) : Boolean{
    return int > 1
}

fun main(){
    print(firstBadVersion(2))
}