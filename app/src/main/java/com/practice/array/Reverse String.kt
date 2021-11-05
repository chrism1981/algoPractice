package com.practice.array

fun reverseString(s: CharArray): Unit {
    var left = 0
    var right = s.size -1
    while (left < right){
        val temp = s[left]
        s[left] = s[right]
        s[right] = temp
        left++
        right--
    }

}

fun main(){
    val array = charArrayOf('a','b','c','d')
    reverseString(array)
    print(array.contentToString())
}