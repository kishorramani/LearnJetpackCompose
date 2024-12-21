package com.kishorramani.jetpackcomposeandroidknowledge.l_list_lazy_column_row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class LListLazyColumnRow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val abcd = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
                    //LearnList(abcd)
                    //LearnLazyColumn(abcd)
                    LearnLazyRow(abcd)
                }
            }
        }
    }
}

@Composable
fun LearnList(list: List<String>) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        list.forEach {
            Text(text = "ABCD - $it", fontSize = 50.sp, color = Color.Red)
        }
    }
}

@Composable
fun LearnLazyColumn(list: List<String>) {
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        items(list) {
            Text(text = "ABCD - $it", fontSize = 50.sp, color = Color.Red)
        }
    }
}

@Composable
fun LearnLazyRow(list: List<String>) {
    LazyRow(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(list) {
            Text(text = it, fontSize = 50.sp, color = Color.Blue)
        }
    }
}

@Composable
fun LearnListLazyColumnRow() {

}

@Preview(showBackground = true)
@Composable
private fun ShowLearnListLazyColumnRow() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnListLazyColumnRow()
    }
}