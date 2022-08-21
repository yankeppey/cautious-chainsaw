package eu.buney.ui.testdatabasetransaction.coroutines

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Andrei Buneyeu
 */
@InstallIn(SingletonComponent::class)
@Module
interface CoroutineDispatchersModule {

    @Binds
    @Singleton
    fun bindCoroutineDispatchers(coroutineDispatchers: AppCoroutineDispatchersImpl): AppCoroutineDispatchers

}