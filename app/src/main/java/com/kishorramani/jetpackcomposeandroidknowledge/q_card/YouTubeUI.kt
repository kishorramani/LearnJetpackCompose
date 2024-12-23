package com.kishorramani.jetpackcomposeandroidknowledge.q_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishorramani.jetpackcomposeandroidknowledge.R
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.GreenColor
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

@Composable
fun YouTubeUI(youTubeData: YouTubeData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.background(GreenColor)
        ) {
            Image(
                painter = painterResource(id = youTubeData.thumbnail),
                contentDescription = youTubeData.videoTitle,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = youTubeData.videoTitle,
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 18.sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = youTubeData.videoDescription,
                    maxLines = 1,
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ShowYouTubeUI() {
    JetpackComposeAndroidKnowledgeTheme {
        YouTubeUI(YouTubeData(R.drawable.icons, "Title", "Description"))
    }
}