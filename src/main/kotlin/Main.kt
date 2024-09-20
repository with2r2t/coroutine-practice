package org.example

import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    doWorld()
    println("Done") // main coroutine continues while a previous one is delayed
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    launch{
        delay(3000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World?") // print after delay
    }
    println("Hello")
}