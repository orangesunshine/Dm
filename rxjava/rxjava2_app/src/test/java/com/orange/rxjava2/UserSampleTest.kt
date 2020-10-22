package com.orange.rxjava2

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function3
import org.junit.Test
import java.lang.Error
import java.util.concurrent.Callable
import kotlin.random.Random

class UserSampleTest {
    val ran = Random

    @Test
    fun rxjavaCallable() {
        var a = 100
        val fromCallable: Observable<Int> = Observable.fromCallable(Callable<Int> {
            println("fromCallable")
            a
        })
        val observe = Consumer<Int> { println("rxjavaCallable: ${it}") }
        fromCallable
            .subscribe(observe)
        a = 200
        fromCallable
            .subscribe(observe)
    }

    @Test
    fun rxjavaGroupBy() {
        Observable.just(5, 2, 3, 4, 1, 6, 8, 9, 7, 10)
            .groupBy({
                it % 3
            })
            .subscribe({
                val key = it.key
                it.subscribe({ println("key: ${key}, it: ${it}") })
            })
    }

    @Test
    fun rxjavaConcat() {
        val observable1 = observable()
        val observable2 = observable()
        val observable3 = observable()
        Observable.zip(observable1, observable2, observable3, { t1, t2, t3 ->
            t1 + t2 + t3
        })
            .subscribe({
                println("rxjavaConcat__subscribe__it: ${it}")
            })
        println("rxjavaConcat__thread__id: ${Thread.currentThread().id}, name: ${Thread.currentThread().name}")
        Thread.sleep(10000)
    }

    fun observable(): Observable<Int> {
        return Observable.create({
            println("create__thread__id: ${Thread.currentThread().id}, name: ${Thread.currentThread().name}}")
            val callable = Callable<Int> { ran.nextInt(100) }
            Thread({
                val sleep = ran.nextLong(5000)
                println("thread__id: ${Thread.currentThread().id}, name: ${Thread.currentThread().name}__start__sleep: ${sleep}")
                Thread.sleep(sleep)
                val ret = callable.call()
                println("thread__id: ${Thread.currentThread().id}, name: ${Thread.currentThread().name}__end__ret: ${ret}")
                it.onNext(ret)
                it.onComplete()
            }).start()
        })
    }

    fun observable1(): Observable<Int> {
        return Observable.create({
            println("create__thread__id: ${Thread.currentThread().id}, name: ${Thread.currentThread().name}}")
            it.onNext(ran.nextInt(100))
        })
    }
}