package com.gmail.beprogressive.it.testlab.exp

import com.gmail.beprogressive.it.testlab.log
import java.util.*

object ExpArrayReverse {
    fun start() {
        reverse()
    }

    private val list = LinkedList(listOf(1.0, 2.0, 3.0))

    private fun reverse() {
        log("reverse list size: ${list.size}")
        val newList = LinkedList<Double>()
        for (i in list.size - 1..0) {
            log("add: $i")
            newList.add(list[i])
        }
        var logString = ""
        newList.forEach {
            logString += "$it, "
        }
        log("reverse newList: $logString")
    }
}