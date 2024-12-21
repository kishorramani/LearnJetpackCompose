package com.kishorramani.jetpackcomposeandroidknowledge.m_constraint_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class MConstraintLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnConstraintLayout()
                }
            }
        }
    }
}

@Composable
fun LearnConstraintLayout() {
    ConstraintLayout {
        val (btRed, btGreen, btBlue, btBlack) = createRefs()
        val guideLine = createGuidelineFromBottom(0.01f)

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier.constrainAs(btRed) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.value(120.dp)
            }
        ) {
            Text(text = "RED")
        }
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.constrainAs(btGreen) {
                top.linkTo(btRed.bottom)
            }
        ) {
            Text(text = "Green")
        }
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.constrainAs(btBlue) {
                top.linkTo(btRed.bottom)
            }
        ) {
            Text(text = "BLUE")
        }
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.constrainAs(btBlack) {
                start.linkTo(btBlue.start)
                end.linkTo(btGreen.end)
                top.linkTo(btGreen.bottom)
                bottom.linkTo(guideLine)
            }
        ) {
            Text(text = "BLACK")
        }
        createHorizontalChain(btBlue, btGreen, chainStyle = ChainStyle.Spread)
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnListLazyColumnRow() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnConstraintLayout()
    }
}