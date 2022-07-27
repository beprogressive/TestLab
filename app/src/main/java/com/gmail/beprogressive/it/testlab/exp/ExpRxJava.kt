package com.gmail.beprogressive.it.testlab.exp

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.FlowableEmitter
import io.reactivex.rxjava3.schedulers.Schedulers

object ExpRxJava {
    fun run() {
        test1()
    }

    private fun test() {
        Flowable.just("Hello world").subscribe(System.out::println)
    }

    private fun test1() {
        val flow = Flowable.create ({ emitter: FlowableEmitter<Int> ->
            for (i in 0..99)
                emitter.onNext(test2(i))
            emitter.onComplete()
        }, BackpressureStrategy.BUFFER)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.toString()
            }
            .filter {
                it.length > 1
            }
            .filter {
                it.contains("0")
            }

        flow.subscribe(System.out::println)
    }

    private fun test2(value: Int): Int {
        Thread.sleep(100)
        return value+1
    }
}