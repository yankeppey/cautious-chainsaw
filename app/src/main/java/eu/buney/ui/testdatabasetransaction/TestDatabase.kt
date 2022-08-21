package eu.buney.ui.testdatabasetransaction;

import androidx.room.*

/**
 * @author Andrei Buneyeu
 */
@Database(
    entities = [TestEntity::class],
    version = 1, exportSchema = false
)
abstract class TestDatabase : RoomDatabase() {

    abstract fun testDao(): TestDao

}


