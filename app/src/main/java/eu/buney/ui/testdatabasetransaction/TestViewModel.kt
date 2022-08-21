package eu.buney.ui.testdatabasetransaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.buney.ui.testdatabasetransaction.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val testRepository: TestRepository,
    private val appCoroutineDispatchers: AppCoroutineDispatchers,
) : ViewModel(), ITestViewModel {

    override val uiState: Flow<TestScreenUiState> = testRepository
        .getAllTestEntitiesCount()
        .map { count -> TestScreenUiState(count = count) }
        .flowOn(appCoroutineDispatchers.default)
        .stateIn(viewModelScope, started = SharingStarted.Eagerly, initialValue = TestScreenUiState())

    override fun onAddEntityClick() {
        viewModelScope.launch(appCoroutineDispatchers.default) {
            testRepository.addTestEntity(TestEntity())
        }
    }

}