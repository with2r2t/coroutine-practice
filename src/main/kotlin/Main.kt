package org.example

import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    doWorld()
    launch(Dispatchers.IO) {
        println(ioFun())
    }
    launch(Dispatchers.Default) {
        println(defaultFun())
    }
    launch(Dispatchers.Main) {
        println(dispatcherFun())
    }
    println("Done") // main coroutine continues while a previous one is delayed
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(3000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    launch{
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World?") // print after delay
    }
    println("Hello")
}

suspend fun ioFun(): String {
    delay(1000L)
    return "I am IO"
}

suspend fun defaultFun(): String {
    delay(1000L)
    return "I am default"
}

suspend fun dispatcherFun(): String {
    delay(1000L)
    return "I am dispatcher"
}