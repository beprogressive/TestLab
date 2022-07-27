package com.gmail.beprogressive.it.testlab.exp

import com.gmail.beprogressive.it.testlab.log
import kotlinx.coroutines.*

object ExpCoroutine {
    fun run() {
        switchCoroutine()
    }

    private var timerJob: Job? = null

    private fun switchCoroutine() {
        if (timerJob != null) {
            timerJob?.cancel("Cancel timerJob")
            timerJob = null
            return
        }

        timerJob = Job().apply {
            val context = this + Dispatchers.IO + CoroutineName("timerCoroutine")
            CoroutineScope(context).launch {
                while (true) {
                    log("coroutineContext: ${coroutineContext[CoroutineName.Key]?.name}")
                    delay(2000)
                }
            }
        }
    }
}