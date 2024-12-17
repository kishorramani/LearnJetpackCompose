package com.kishorramani.jetpackcomposeandroidknowledge.h_bottom_navigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.GreenColor
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class GBottomNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnBottomNavigation()
                }
            }
        }
    }
}


@Composable
fun LearnBottomNavigation() {
    val context = LocalContext.current.applicationContext
    val navigationController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = GreenColor,
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(HScreens.Home.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(24.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(HScreens.Search.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp),
                        tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(onClick = { Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show() }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Settings
                        navigationController.navigate(HScreens.Settings.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Setting",
                        modifier = Modifier.size(24.dp),
                        tint = if (selected.value == Icons.Default.Settings) Color.White else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(HScreens.Profile.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(24.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = HScreens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(HScreens.Home.screen) { HHome() }
            composable(HScreens.Search.screen) { HSearch() }
            composable(HScreens.Profile.screen) { HProfile() }
            composable(HScreens.Settings.screen) { HSetting() }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowBottomNavigation() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnBottomNavigation()
    }
}