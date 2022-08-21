@file:OptIn(ExperimentalCoroutinesApi::class)

package eu.buney.ui.testdatabasetransaction.coroutines

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import eu.buney.ui.testdatabasetransaction.coroutines.AppCoroutineDispatchers
import eu.buney.ui.testdatabasetransaction.coroutines.CoroutineDispatchersModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CoroutineDispatchersModule::class])
@Module
class FakeCoroutineDispatchersModule {

    @Provides
    @Singleton
    fun provideTestDispatcher(): TestDispatcher = StandardTestDispatcher()

    @Provides
    @Singleton
    fun provideCoroutineDispatchers(test: TestCoroutinesDispatchers): AppCoroutineDispatchers = test

}