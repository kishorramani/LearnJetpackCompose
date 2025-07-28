package com.kishorramani.jetpackcomposeandroidknowledge.i_bottom_sheet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.GreenColor
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class IBottomSheet : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnBottomSheet()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnBottomSheet() {
    val context = LocalContext.current.applicationContext
    val navigationController = rememberNavController()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center,
        ) {
            Button(onClick = {
                showBottomSheet = true
            }) {
                Text("Open Bottom Sheet")
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                IBottomSheetItem(icon = Icons.Default.ThumbUp, "Post") {
                    showBottomSheet = false
                    navigationController.navigate(IScreens.Post.screen) {
                        popUpTo(0)
                    }
                }
                IBottomSheetItem(icon = Icons.Default.Star, "Rate us") {
                    Toast.makeText(context, "Rate us", Toast.LENGTH_SHORT).show()
                }
                IBottomSheetItem(icon = Icons.Default.PlayArrow, "Go to Play Store") {
                    Toast.makeText(context, "Play Store", Toast.LENGTH_SHORT).show()
                }
                IBottomSheetItem(icon = Icons.Default.Email, "Email Us") {
                    Toast.makeText(context, "Email Us", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    NavHost(
        navController = navigationController,
        startDestination = IScreens.Home.screen
    ) {
        composable(IScreens.Home.screen) { IHome() }
        composable(IScreens.Post.screen) { IPost() }
    }
}

@Composable
fun IBottomSheetItem(icon: ImageVector, title: String, onclick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(
            //Jetpack Compose now requires you to explicitly define how a ripple effect (indication) and interaction feedback (interactionSource) behave. Not passing them results in: IllegalArgumentException: clickable only supports IndicationNodeFactory
            interactionSource = remember { MutableInteractionSource() },
            indication = LocalIndication.current,
        ) {
            onclick()
        }
    ) {
        Icon(imageVector = icon, contentDescription = title, tint = GreenColor)
        Text(text = title, color = GreenColor, fontSize = 32.sp)
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowBottomSheet() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnBottomSheet()
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowBottomSheetItemPreview() {
    JetpackComposeAndroidKnowledgeTheme {
        IBottomSheetItem(
            icon = Icons.Default.Home,
            title = "Home",
            onclick = { /* No action for preview */ }
        )
    }
}