package com.kishorramani.jetpackcomposeandroidknowledge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class BRowColumnBox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnRowColumnBox()
                }
            }
        }
    }
}

@Composable
fun LearnRowColumnBox() {
    /*Text(text = "Hello Column")
    Text(text = "Hello Row")
    Text(text = "Hello Box")*/

    /*Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Text Column 1")
        Text(text = "Text Column 2")
    }*/

    /*Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Text Row 1")
        Text(text = "Text Row 2")
    }*/

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .background(Color.Yellow)
        ) {
            Text(
                text = "Hello Box",
                modifier = Modifier.align(Alignment.Center),
                color = Color.Red
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnRowColumnBox() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnRowColumnBox()
    }
}