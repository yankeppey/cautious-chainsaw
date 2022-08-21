package eu.buney.ui.testdatabasetransaction

import android.util.Log
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.coroutineContext

/**
 * @author Andrei Buneyeu
 */
@Dao
abstract class TestDao {

    @Query("SELECT COUNT(*) FROM test")
    abstract fun getAllTestEntitiesCount(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addTestEntity(entity: TestEntity)

    @Transaction
    open suspend fun addTestEntityWithTransaction(entity: TestEntity) {
        // dispatcher is not going to be TestDispatcher here!
        addTestEntity(entity)
    }
}