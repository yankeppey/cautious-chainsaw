package eu.buney.ui.testdatabasetransaction

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * @author Andrei Buneyeu
 */
interface ITestViewModel {
    val uiState: Flow<TestScreenUiState>
    fun onAddEntityClick()
}

val testViewModelStub = object : ITestViewModel {
    override val uiState: Flow<TestScreenUiState> = flowOf(TestScreenUiState())

    override fun onAddEntityClick() {
    }

}