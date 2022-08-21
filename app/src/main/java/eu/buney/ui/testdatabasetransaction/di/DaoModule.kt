package eu.buney.ui.testdatabasetransaction.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.buney.ui.testdatabasetransaction.TestDao
import eu.buney.ui.testdatabasetransaction.TestDatabase
import javax.inject.Singleton

/**
 * @author Andrei Buneyeu
 */
@InstallIn(SingletonComponent::class)
@Module
class DaoModule {

    @Provides
    @Singleton
    fun testDao(database: TestDatabase): TestDao = database.testDao()
}