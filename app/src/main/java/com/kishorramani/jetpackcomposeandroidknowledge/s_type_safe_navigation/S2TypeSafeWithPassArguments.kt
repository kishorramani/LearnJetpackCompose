package com.kishorramani.jetpackcomposeandroidknowledge.s_type_safe_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme
import kotlinx.serialization.Serializable

//Here, I use primitive type argument
class S2TypeSafeWithPassArguments : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController, startDestination = Dest1.ScreenP
                    ) {
                        composable<Dest1.ScreenP> {
                            ScreenP {
                                navController.navigate(
                                    Dest1.ScreenQ(age = null, name = "kishor")
                                )
                            }
                        }

                        composable<Dest1.ScreenQ>() {
                            val age = it.toRoute<Dest1.ScreenQ>().age ?: 0
                            val name = it.toRoute<Dest1.ScreenQ>().name
                            ScreenQ(
                                age = age,
                                name = name
                            ) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}

sealed interface Dest1 {
    @Serializable
    data object ScreenP : Dest

    @Serializable
    data class ScreenQ(
        val age: Int?,
        val name: String
    ) : Dest
}

@Composable
fun ScreenP(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = onClick) {
            Text("Screen P")
        }
    }
}

@Composable
fun ScreenQ(modifier: Modifier = Modifier, age: Int, name: String, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = onClick) {
            Column {
                Text("age -> $age , Name-> $name")
                Spacer(Modifier.height(12.dp))
                Text("Screen Q")
            }
        }
    }
}