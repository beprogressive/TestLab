package com.gmail.beprogressive.it.testlab.exp

import com.gmail.beprogressive.it.testlab.log

object TestMath {
    fun start() {
        val result = calculate()
        log("result negatives: " + result.countOfNegatives)
        log("result negatives mean: " + result.getNegativesMean())
        log("result positives: " + result.countOfPositives)
        log("result positives mean: " + result.getPositivesMean())
    }

    private val items = listOf(1, -2, -3, 4, 5, 0, 2, -2)

    private var pCount = 0
    private var pSum = 0
    private var nCount = 0
    private var nSum = 0

    private fun calculate(): Result {
        for (item in items) {
            if (item < 0) {
                nCount++
                nSum += item
            } else {
                pCount++
                pSum += item
            }
        }

        return Result(pCount, pSum, nCount, nSum)
    }

    class Result(
        private val pCount: Int,
        private val pSum: Int,
        private val nCount: Int,
        private val nSum: Int
    ) {
        val countOfNegatives = nCount
        val countOfPositives = pCount

        fun getPositivesMean(): Float {
            return pSum / pCount.toFloat()
        }

        fun getNegativesMean(): Float {
            return nSum / nCount.toFloat()
        }
    }
}