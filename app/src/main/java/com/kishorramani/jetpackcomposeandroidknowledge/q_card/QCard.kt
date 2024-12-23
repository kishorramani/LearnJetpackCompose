package com.kishorramani.jetpackcomposeandroidknowledge.q_card

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishorramani.jetpackcomposeandroidknowledge.R
import com.kishorramani.jetpackcomposeandroidknowledge.l_list_lazy_column_row.LearnLazyColumn
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.GreenColor
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class QCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnCard()
                }
            }
        }
    }
}

@Composable
fun LearnCard() {
    val videoList = listOf(
        YouTubeData(R.drawable.ic_launcher_icon, "Title", LoremIpsum(5).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title1", LoremIpsum(3).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title2", LoremIpsum(6).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title3", LoremIpsum(10).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title4", LoremIpsum(1).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title5", LoremIpsum(3).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title6", LoremIpsum(4).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title7", LoremIpsum(6).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title8", LoremIpsum(5).toString()),
        YouTubeData(R.drawable.ic_launcher_icon, "Title9", LoremIpsum(5).toString())
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(10.dp)
    ) {
        items(videoList) {
            YouTubeUI(it)
        }
    }
}


@Preview(showBackground = true)
@PreviewLightDark
@Composable
private fun ShowLearnCard() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnCard()
    }
}