package eu.buney.ui.testdatabasetransaction.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Andrei Buneyeu
 */
interface AppCoroutineDispatchers {

    val main: CoroutineDispatcher

    val unconfined: CoroutineDispatcher

    val default: CoroutineDispatcher

    val io: CoroutineDispatcher
}