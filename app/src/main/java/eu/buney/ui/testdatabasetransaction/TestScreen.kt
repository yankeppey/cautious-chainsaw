package eu.buney.ui.testdatabasetransaction

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * @author Andrei Buneyeu
 */
@Composable
fun TestScreen(viewModel: ITestViewModel = hiltViewModel<TestViewModel>()) {
    val uiState by viewModel.uiState.collectAsState(initial = TestScreenUiState())
    Column {
        Text("Count: ${uiState.count}")

        Button(onClick = { viewModel.onAddEntityClick() }) {
            Text("Add Entity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestScreenPreview() {
    TestScreen(testViewModelStub)
}