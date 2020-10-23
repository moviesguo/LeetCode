package com.moviesguo.leetcode



class A {
    fun foo() {
        println("0")
    }
}

fun foo(): () -> Unit {
    var i = 0
    return {
        println(i++)
    }
}




fun main() {
    val f1 = foo()
    val f2 = foo()
    f1()
    f1()
    f2()

}
