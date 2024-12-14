package com.kishorramani.jetpackcomposeandroidknowledge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class DButtonAndImage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //LearnButton()
                    LearnImage()
                }
            }
        }
    }
}

@Composable
fun LearnButton() {
    val context = LocalContext.current.applicationContext
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { Toast.makeText(context, "Clicked Success", Toast.LENGTH_SHORT).show() },
            shape = RoundedCornerShape(size = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Click me")
        }
    }
}

@Composable
fun LearnImage() {
    Image(painter = painterResource(R.drawable.icons), contentDescription = null)
}



@Preview(showBackground = true)
@Composable
private fun ShowLearnButton() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnButton()
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnImage() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnImage()
    }
}