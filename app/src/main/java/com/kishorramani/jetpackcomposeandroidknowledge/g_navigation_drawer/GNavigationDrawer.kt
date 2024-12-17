package com.kishorramani.jetpackcomposeandroidknowledge.g_navigation_drawer

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

class GNavigationDrawer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnNavigationDrawer()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavigationDrawer() {
    val context = LocalContext.current.applicationContext
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(GreenColor)
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Text(text = "")
                }
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home", color = GreenColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home", tint = GreenColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(GScreens.Home.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text(text = "Profile", color = GreenColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = GreenColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(GScreens.Profile.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text(text = "Settings", color = GreenColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings", tint = GreenColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(GScreens.Settings.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text(text = "Logout", color = GreenColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "Logout", tint = GreenColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout Successfully", Toast.LENGTH_SHORT).show()
                    },
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                //val coroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = { Text(text = "XPerts") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenColor,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu,
                                contentDescription = "Menu Button"
                            )
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navigationController,
                startDestination = GScreens.Home.screen
            ) {
                composable(GScreens.Home.screen) { GHome() }
                composable(GScreens.Profile.screen) { GProfile() }
                composable(GScreens.Settings.screen) { GSetting() }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowNavigationDrawer() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnNavigationDrawer()
    }
}