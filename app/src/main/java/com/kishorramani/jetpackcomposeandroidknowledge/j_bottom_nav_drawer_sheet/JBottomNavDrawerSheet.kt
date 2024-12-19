package com.kishorramani.jetpackcomposeandroidknowledge.j_bottom_nav_drawer_sheet

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import kotlinx.coroutines.launch

class JBottomNavDrawerSheet : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnBottomNavDrawerSheet()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnBottomNavDrawerSheet() {
    val context = LocalContext.current.applicationContext
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val sheetState = rememberModalBottomSheetState()

    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

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
                    label = { Text(text = "Dashboard", color = GreenColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Star, contentDescription = "Dashboard", tint = GreenColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(JAllScreens.Dashboard.screen) {
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
                        navigationController.navigate(JAllScreens.Settings.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text(text = "About Us", color = GreenColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Warning, contentDescription = "About Us", tint = GreenColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(JAllScreens.AboutUs.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text(text = "Help & Support", color = GreenColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Help & Support", tint = GreenColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(JAllScreens.HelpAndSupport.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text(text = "Exit App", color = GreenColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "Exit App", tint = GreenColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Exit Successfully", Toast.LENGTH_SHORT).show()
                    },
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
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
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = GreenColor,
                ) {
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Home
                            navigationController.navigate(JAllScreens.Home.screen) {
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
                            navigationController.navigate(JAllScreens.Search.screen) {
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
                        FloatingActionButton(onClick = { showBottomSheet = true }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Favorite
                            navigationController.navigate(JAllScreens.Favorite.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            modifier = Modifier.size(24.dp),
                            tint = if (selected.value == Icons.Default.Favorite) Color.White else Color.DarkGray
                        )
                    }

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Person
                            navigationController.navigate(JAllScreens.Profile.screen) {
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
        ) {
            NavHost(
                navController = navigationController,
                startDestination = JAllScreens.Home.screen
            ) {
                composable(JAllScreens.Home.screen) { JHome() }
                composable(JAllScreens.Search.screen) { JSearch() }
                composable(JAllScreens.Favorite.screen) { JFavorite() }
                composable(JAllScreens.Profile.screen) { JProfile() }

                composable(JAllScreens.Dashboard.screen) { JDashBoard() }
                composable(JAllScreens.Settings.screen) { JSettings() }
                composable(JAllScreens.AboutUs.screen) { JAboutUs() }
                composable(JAllScreens.HelpAndSupport.screen) { JHelpAndSupport() }

                composable(JAllScreens.Post.screen) { JPost() }
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
                JBottomSheetItem(icon = Icons.Default.ThumbUp, "Post") {
                    showBottomSheet = false
                    navigationController.navigate(JAllScreens.Post.screen) {
                        popUpTo(0)
                    }
                }
                JBottomSheetItem(icon = Icons.Default.Star, "Rate us") {
                    Toast.makeText(context, "Rate us", Toast.LENGTH_SHORT).show()
                }
                JBottomSheetItem(icon = Icons.Default.PlayArrow, "Go to Play Store") {
                    Toast.makeText(context, "Play Store", Toast.LENGTH_SHORT).show()
                }
                JBottomSheetItem(icon = Icons.Default.Email, "Email Us") {
                    Toast.makeText(context, "Email Us", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun JBottomSheetItem(icon: ImageVector, title: String, onclick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onclick() }
    ) {
        Icon(imageVector = icon, contentDescription = title, tint = GreenColor)
        Text(text = title, color = GreenColor, fontSize = 32.sp)
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowBottomSheet() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnBottomNavDrawerSheet()
    }
}