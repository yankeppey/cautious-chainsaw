/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.buney.ui.testdatabasetransaction.util

import android.annotation.SuppressLint
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.DefaultTaskExecutor
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * A JUnit Test Rule that swaps the background executor used by the Architecture Components with a
 * different one which counts the tasks as they are start and finish.
 *
 * You can use this rule for your host side tests that use Architecture Components.
 *
 * The rule inspired by Espresso Idling Resource (see https://github.com/android/android-test/blob/master/espresso/idling_resource/java/androidx/test/espresso/idling/CountingIdlingResource.java)
 * and CountingTaskExecutorRule (https://developer.android.com/reference/android/arch/core/executor/testing/CountingTaskExecutorRule) with a difference that it's:
 * - written in kotlin
 * - does not block thread but uses coroutines to wait for the tasks to finish
 *
 * @author Andrei Buneyeu
 */
class IdlingArchTaskExecutorRule : TestWatcher() {

    fun interface IdleTransitionCallback {
        fun onTransitionToIdle()
    }

    private var idleTransitionCallback: IdleTransitionCallback? = null

    private val taskCount: AtomicInteger = AtomicInteger(0)

    @SuppressLint("RestrictedApi")
    override fun starting(description: Description?) {
        super.starting(description)
        ArchTaskExecutor.getInstance().setDelegate(object : DefaultTaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                super.executeOnDiskIO(CountingRunnable(runnable))
            }

            override fun postToMainThread(runnable: Runnable) {
                super.postToMainThread(CountingRunnable(runnable))
            }
        })
    }

    @SuppressLint("RestrictedApi")
    override fun finished(description: Description?) {
        super.finished(description)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    private fun increment() {
        taskCount.incrementAndGet()
    }

    private fun decrement() {
        val taskCountVal = taskCount.decrementAndGet()
        if (taskCountVal == 0) {
            // we've gone from non-zero to zero. That means we're idle now!
            idleTransitionCallback?.onTransitionToIdle();
        }
    }

    fun registerIdleTransitionCallback(callback: IdleTransitionCallback?) {
        this.idleTransitionCallback = callback
    }

    inner class CountingRunnable(private val wrapped: Runnable) : Runnable {
        override fun run() {
            try {
                wrapped.run()
            } finally {
                decrement()
            }
        }

        init {
            increment()
        }
    }
}

/**
 * Suspends until the given [IdlingArchTaskExecutorRule] is idle.
 *
 * @author Andrei Buneyeu
 */
suspend fun IdlingArchTaskExecutorRule.waitUntilIdle() {
    suspendCoroutine {
        registerIdleTransitionCallback {
            it.resume(Unit)
            registerIdleTransitionCallback(null)
        }
    }
}
