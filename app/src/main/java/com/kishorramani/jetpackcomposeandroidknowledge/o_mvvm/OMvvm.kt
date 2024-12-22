package com.kishorramani.jetpackcomposeandroidknowledge.o_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kishorramani.jetpackcomposeandroidknowledge.n_navigation_component.LearnNavigationComponent
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class OMvvm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //LearnWithoutMVVM()
                    LearnWithMVVM()
                }
            }
        }
    }
}

@Composable
fun LearnWithoutMVVM() {
    var count by remember {
        mutableStateOf(0)
    }

    Column {
        Button(onClick = {
            count++
        }) {
            Text(text = "Click Me")
        }
        Text(text = "counter value: $count")
    }
}

@Composable
fun LearnWithMVVM(viewModel: OViewModel = viewModel()) {
    Column {
        Button(onClick = {
            viewModel.incrementCounter()
        }) {
            Text(text = "Click Me")
        }
        Text(text = "counter value: ${viewModel.count}")
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnWithoutMVVM() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnWithoutMVVM()
    }
}