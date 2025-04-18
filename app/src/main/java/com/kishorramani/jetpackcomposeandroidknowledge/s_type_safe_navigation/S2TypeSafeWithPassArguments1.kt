package com.kishorramani.jetpackcomposeandroidknowledge.s_type_safe_navigation

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

//Here, I use Data class as an type argument
class S2TypeSafeWithPassArguments1 : ComponentActivity() {
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
                        navController = navController, startDestination = Dest2.ScreenE
                    ) {
                        composable<Dest2.ScreenE> {
                            ScreenE {
                                navController.navigate(
                                    // Dest2.ScreenF(Dummy(age = 20, name = "kishor"))
                                    Dest2.ScreenF(null)
                                )
                            }
                        }

                        composable<Dest2.ScreenF>(
                            typeMap = mapOf(
                                typeOf<Dummy>() to CustomNavType<Dummy>(
                                    Dummy::class.java,
                                    Dummy.serializer()
                                ),
                                typeOf<Dummy?>() to CustomNavType<Dummy>(
                                    Dummy::class.java,
                                    Dummy.serializer()
                                )
                            )
                        ) {
                            val dummy = it.toRoute<Dest2.ScreenF>().dummy
                            ScreenF(
                                age = dummy?.age ?: 0,
                                name = dummy?.name ?: "null"
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

class CustomNavType<T : Parcelable>(
    private val clazz: Class<T>,
    private val serializer: KSerializer<T>
) : NavType<T?>(isNullableAllowed = true) {
    companion object {
        const val NULL = "null"
    }

    override fun get(bundle: Bundle, key: String): T? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, clazz)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): T? {
        return if (value == NULL) null else Json.decodeFromString(serializer, value)
    }

    override fun put(bundle: Bundle, key: String, value: T?) {
        bundle.putParcelable(key, value)
    }

    override fun serializeAsValue(value: T?): String {
        return value?.let { Json.encodeToString(serializer, it) } ?: NULL
    }
}

sealed interface Dest2 {
    @Serializable
    data object ScreenE : Dest

    @Serializable
    data class ScreenF(
        val dummy: Dummy?
    ) : Dest
}

@Serializable
@Parcelize
data class Dummy(
    val name: String,
    val age: Int
) : Parcelable

@Composable
fun ScreenE(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = onClick) {
            Text("Screen E")
        }
    }
}

@Composable
fun ScreenF(modifier: Modifier = Modifier, age: Int, name: String, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = onClick) {
            Column {
                Text("age -> $age , Name-> $name")
                Spacer(Modifier.height(12.dp))
                Text("Screen F")
            }
        }
    }
}