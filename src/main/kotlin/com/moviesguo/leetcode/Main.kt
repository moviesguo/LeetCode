package com.moviesguo.leetcode

import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


fun main() {
//    runBlocking {
//        val start = System.currentTimeMillis()
//        val deferred = withContext(Dispatchers.IO) {
//            delay(2000)
//            println("async1")
//        }
//        val deferred1 = withContext(Dispatchers.IO) {
//            delay(1000)
//            println("async2")
//        }
//        println("${System.currentTimeMillis() - start}")
//    }

    runBlocking {
        foo()
        launch {
            delay(1000)
            println("launch1")
        }
    }

//    runBlocking {
//        launch { println("1")
//        delay(1000)
//         println("1 finish")
//        }
//        launch {
//            println("2")
//            delay(1000)
//            println("2 fiish")
//        }
//    }

}

suspend fun foo() = coroutineScope{
    launch {
        delay(2000)
        println("launch")
    }
    launch {
        delay(1000)
        println("launch2")
    }
    return@coroutineScope 0
}


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
