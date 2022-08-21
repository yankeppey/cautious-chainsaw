package eu.buney.ui.testdatabasetransaction.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import eu.buney.ui.testdatabasetransaction.TestDatabase
import javax.inject.Singleton

/**
 * @author Andrei Buneyeu
 */
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideTestDatabase(@ApplicationContext appContext: Context): TestDatabase {
        return Room.inMemoryDatabaseBuilder(appContext, TestDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

}