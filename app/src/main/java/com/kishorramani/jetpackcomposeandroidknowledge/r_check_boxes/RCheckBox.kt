package com.kishorramani.jetpackcomposeandroidknowledge.r_check_boxes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class RCheckBox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnCheckBox()
                }
            }
        }
    }
}

@Composable
fun LearnCheckBox() {
    val list: List<String> = listOf("A", "B", "C", "D", "E")
    val context = LocalContext.current.applicationContext

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        list.forEach { item ->
            var checkedItem by remember { mutableStateOf(false) }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = checkedItem, onCheckedChange = { checkedStatus ->
                    checkedItem = checkedStatus
                    Toast.makeText(context, "Item $item is $checkedItem", Toast.LENGTH_SHORT).show()
                })
                Text(text = item, fontSize = 22.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@PreviewLightDark
@Composable
private fun ShowLearnCheckBox() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnCheckBox()
    }
}