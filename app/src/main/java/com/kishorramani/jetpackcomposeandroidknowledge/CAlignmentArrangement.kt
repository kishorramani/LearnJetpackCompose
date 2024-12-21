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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class CAlignmentAndArrangement : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnAlignmentAndArrangement()
                }
            }
        }
    }
}

@Composable
fun LearnAlignmentAndArrangement() {
    //Alignment[Position] - Cross Axis => Alignment refers to the positioning of the composable element within its parent container, specifying how it should be placed relative to the available space along the horizontal and vertical axis
    //Arrangement - Main Axis => Arrangement defines the distribution of multiple composable within a container, determining their placement along the main axis

    //Row Alignment -> Vertical
    //Alignment parameter => Top, Center vertically, bottom
    //Row Arrangement = Horizontal
    //Arrangement parameter => Start, Center, End
    //                         SpaceBetween, SpaceAround, SpaceEvenly
    //                         Absolute.left, Absolute.Right, Absolute.Center
    //                         Absolute.SpaceBetween, Absolute.SpaceAround, Absolute.SpaceEvenly
    /*Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = "Row Alignment Arrangement")
    }*/

    //Column Alignment -> Horizontal
    //Alignment parameter => Start, Center Horizontally, End
    //Column Arrangement = Vertical
    //Arrangement parameter => Top, Center, Bottom - Space Between, Space Around, Space Evenly
    /*Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Colum Alignment Arrangement")
    }*/

    //Box => Only Alignment is working
    //Alignment parameter => TopStart, TopCenter, TopEnd, BottomStart, BottomCenter, BottomEnd, Center, CenterStart, CenterEnd
    Box(
        contentAlignment = Alignment.BottomStart        //This is not work if child has alignment
    ) {
        Text(text = "TopStart", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "TopCenter", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "TopEnd", modifier = Modifier.align(Alignment.TopEnd))
        Text(text = "BottomStart", modifier = Modifier.align(Alignment.BottomStart))
        Text(text = "BottomCenter", modifier = Modifier.align(Alignment.BottomCenter))
        Text(text = "BottomEnd", modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "Center", modifier = Modifier.align(Alignment.Center))
        Text(text = "CenterStart", modifier = Modifier.align(Alignment.CenterStart))
        Text(text = "CenterEnd", modifier = Modifier.align(Alignment.CenterEnd))
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnAlignmentAndArrangement() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnAlignmentAndArrangement()
    }
}