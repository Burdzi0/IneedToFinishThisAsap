package tech.burdzi0.ineedtofinishthisasap.executor

import java.util.concurrent.Callable
import java.util.concurrent.Executors

object Executor {

    private val executorService = Executors.newSingleThreadExecutor()

    fun execute(runnable: Runnable) {
        executorService.execute(runnable)
    }

    fun <T> execute(callable: Callable<T>):T? {
        return executorService.submit(callable).get()
    }
}