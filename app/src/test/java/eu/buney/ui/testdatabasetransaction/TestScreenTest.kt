@file:OptIn(ExperimentalCoroutinesApi::class)

package eu.buney.ui.testdatabasetransaction

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import eu.buney.ui.testdatabasetransaction.util.IdlingArchTaskExecutorRule
import eu.buney.ui.testdatabasetransaction.util.waitUntilIdle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject
import kotlin.test.assertEquals

/**
 * @author Andrei Buneyeu
 */
@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(RobolectricTestRunner::class)
class TestScreenTest {

    @Inject
    lateinit var testDispatcher: TestDispatcher

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val archTaskExecutorRule = IdlingArchTaskExecutorRule()

    private val component by lazy {
        Robolectric.buildActivity(TestActivity::class.java).setup().get()
    }

    @Before
    fun init() {
        hiltRule.inject()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should pass because waitUntilIdle is used`() {
        runTest {
            val state = component.testViewModel.uiState
            assertEquals(0, state.first().count)

            component.testViewModel.onAddEntityClick()
            archTaskExecutorRule.waitUntilIdle()
            advanceUntilIdle()

            assertEquals(1, state.first().count)
        }
    }


    @Test
    fun `should fail because Android Room uses its own executors`() {
        runTest {
            val state = component.testViewModel.uiState
            assertEquals(0, state.first().count)

            component.testViewModel.onAddEntityClick()
            advanceUntilIdle()

            assertEquals(1, state.first().count)
        }
    }
}