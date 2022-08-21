package eu.buney.ui.testdatabasetransaction.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * @author Andrei Buneyeu
 */
class AppCoroutineDispatchersImpl @Inject constructor() : AppCoroutineDispatchers {

    override val main = Dispatchers.Main

    override val unconfined: CoroutineDispatcher = Dispatchers.Unconfined

    override val default = Dispatchers.Default

    override val io = Dispatchers.IO
}