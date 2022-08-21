package eu.buney.ui.testdatabasetransaction

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Andrei Buneyeu
 */
@AndroidEntryPoint
class TestActivity : ComponentActivity() {

    val testViewModel: TestViewModel by viewModels()


}