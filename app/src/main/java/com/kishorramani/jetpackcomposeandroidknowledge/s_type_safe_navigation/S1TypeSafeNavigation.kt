package com.kishorramani.jetpackcomposeandroidknowledge.s_type_safe_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme
import kotlinx.serialization.Serializable

class S1TypeSafeNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController, startDestination = Dest.ScreenA
                    ) {
                        composable<Dest.ScreenA> {
                            ScreenA { navController.navigate(Dest.ScreenB) }
                        }

                        composable<Dest.ScreenB> {
                            ScreenB { navController.popBackStack() }
                        }
                    }
                }
            }
        }
    }
}

sealed interface Dest{
    @Serializable
    data object ScreenA : Dest

    @Serializable
    data object ScreenB : Dest
}

@Composable
fun ScreenA(modifier: Modifier = Modifier,onClick:()->Unit) {
    Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Button(onClick = onClick) {
            Text("Screen A")
        }
    }
}

@Composable
fun ScreenB(modifier: Modifier = Modifier,onClick:()->Unit) {
    Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Button(onClick = onClick) {
            Text("Screen B")
        }
    }
}