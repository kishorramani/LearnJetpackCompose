package com.kishorramani.jetpackcomposeandroidknowledge.n_navigation_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class NNavigationComponent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnNavigationComponent()
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Main Screen", fontSize = 30.sp)
        Button(onClick = {
            /*navController.navigate("HomeScreen") {
                popUpTo(0)
            }*/
            navController.navigate(NDestinations.HomeScreen.toString())
        }) {
            Text("Go To Home Screen")
        }
    }
}

@Composable
fun LearnNavigationComponent() {
    val navController = rememberNavController()
    /*NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(navController = navController)
        }
        composable("HomeScreen") {
            NHomeScreen(navController = navController)
        }
    }*/
    NavHost(navController = navController, startDestination = NDestinations.MainScreen.toString()) {
        composable(route = NDestinations.MainScreen.toString()) {
            MainScreen(navController = navController)
        }
        composable(route = NDestinations.HomeScreen.toString()) {
            NHomeScreen(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnNavigationComponent() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnNavigationComponent()
    }
}