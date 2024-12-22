package com.kishorramani.jetpackcomposeandroidknowledge.p_floating_action_button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.GreenColor
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class PFloatingActionButton : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnFloatingActionButton()
                    LearnExtendedFAB()
                }
            }
        }
    }
}

@Composable
fun LearnFloatingActionButton() {
    val context = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = GreenColor,
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }
    }
}

@Composable
fun LearnExtendedFAB() {
    val context = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {
        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart),
            containerColor = GreenColor,
            onClick = {
                Toast.makeText(context, "Extended FAB Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            Text(text = "Add", modifier = Modifier.padding(4.dp), fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnFloatingActionButton() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnFloatingActionButton()
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnExtendedFAB() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnExtendedFAB()
    }
}