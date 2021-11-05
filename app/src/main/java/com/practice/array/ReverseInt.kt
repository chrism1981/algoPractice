package com.practice.array

fun reverse(x: Int): Int {
    var result = 0
    var remain = x
    while (remain != 0){
        if(result < Int.MIN_VALUE/10 || result  > Int.MAX_VALUE/10)//之前用的 result *10 < Int.MIN_VALUE 这样判断不对，因为result先*10本身就可能已经越界了
                //  判断小于时候， 一定不能放大，因为相当于没判断*10以后是不是超出范围之前，就先做乘法了。
            return 0
        var last = remain % 10
        result = result * 10 + last
        remain /= 10
    }

    return  result

}

fun main(){
    print( reverse(6521))
}