@file:OptIn(ExperimentalCoroutinesApi::class)

package eu.buney.ui.testdatabasetransaction.coroutines

import eu.buney.ui.testdatabasetransaction.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import javax.inject.Inject

class TestCoroutinesDispatchers @Inject constructor(testDispatcher: TestDispatcher) : AppCoroutineDispatchers {

    override val main: TestDispatcher = testDispatcher

    override val unconfined: TestDispatcher = testDispatcher

    override val default: TestDispatcher = testDispatcher

    override val io: TestDispatcher = testDispatcher
}
