package com.practice.array

/**
 * 波峰波谷法
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 *
 * 关键点是，要先卖才可以买，不可连续买。 但是当天是可以卖了在买，所以实际上每个小段波峰加起来，等于总波峰。
 */
class sellStock {

    fun maxProfit(prices: IntArray): Int {
        var profit = 0
//        prices.forEachIndexed { index, i ->
//            if(i < prices[index + 1]){
//                profit += prices[index] - i
//            }
//        }

        for (i in 1 until prices.size){
            if(prices[i] > prices[i - 1]){// 别把第一个忘了
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }
}

fun main(){
    print("price is " + sellStock().maxProfit(intArrayOf(1,3,1,4,4,7,89)))
}