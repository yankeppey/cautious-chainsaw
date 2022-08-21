package eu.buney.ui.testdatabasetransaction

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Andrei Buneyeu
 */
@ViewModelScoped
class TestRepository @Inject constructor(private val testDao: TestDao) {

    fun getAllTestEntitiesCount(): Flow<Int> {
        return testDao.getAllTestEntitiesCount()
    }

    suspend fun addTestEntity(entity: TestEntity) {
        testDao.addTestEntityWithTransaction(entity)
    }

}