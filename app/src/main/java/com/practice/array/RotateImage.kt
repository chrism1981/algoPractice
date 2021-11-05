package com.practice.array

class RotateImage {
}

/**
 * https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
 *   1  2  3       7  4  1   1.先水平翻转 7  8  9  2.后反斜对角翻转 7  4  1
 *   4  5  6  ---> 8  5  2              4  5  6                 8  5  2
 *   7  8  9       9  6  3              1  2  3                 9  6  3
 *   no new array allocated
 */
fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size
    //first step, swap horizentally
    for (i in 0 until n / 2) {// 3 dimension loop 1 time(swap row 1 - row3), 4 d loop 2 time
        //(swap row 1 and 4, row 2 and 3) etc.
        if (n - i - 1 != i) {
            val arrayTop = matrix[i]
            val arrayBottom = matrix[n - i - 1]
            for (j in matrix.indices) {
                val temp = arrayTop[j]
                arrayTop[j] = arrayBottom[j]
                arrayBottom[j] = temp
            }
        }
    }
    for (i in matrix.indices) {
        /* this way has a bug, because when it runs on 01, it is swapped with 10, but when
        the loop runs on 10, it will swap the 10 and 01 again, so everything go to the origin.
        for (j in matrix.indices) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }*/
        for (j in 0 until i){// no need to loop every elements just 10; 20,21; ...
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }

    }

}

fun main() {
    val size = 3
    val matrix = Array(size) { IntArray(size) }
    var step = 1
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            matrix[i][j] = step
            step++
        }
    }
    rotate(matrix)

    matrix.forEach {
        print(
            it.contentToString() + "\n"
        )
    }
}