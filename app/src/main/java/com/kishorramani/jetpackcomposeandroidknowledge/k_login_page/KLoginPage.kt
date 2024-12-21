package com.kishorramani.jetpackcomposeandroidknowledge.k_login_page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.GreenColor
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class KLoginPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController)
                }
            }
        }
    }
}


@Composable
fun LearnLoginPage(onLoginSuccess: () -> Unit) {
    val context = LocalContext.current.applicationContext
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 140.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "UserName") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = GreenColor,
                unfocusedLeadingIconColor = Color.Black,
                focusedLabelColor = GreenColor,
                unfocusedLabelColor = Color.Black,
                focusedContainerColor = Color.Green,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = GreenColor,
                unfocusedIndicatorColor = Color.Black,
                unfocusedPlaceholderColor = GreenColor
            ), leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Username")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = GreenColor,
                unfocusedLeadingIconColor = Color.Black,
                focusedLabelColor = GreenColor,
                unfocusedLabelColor = Color.Black,
                focusedContainerColor = Color.Green,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = GreenColor,
                unfocusedIndicatorColor = Color.Black,
                unfocusedPlaceholderColor = GreenColor
            ), leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                if (authenticate(userName, password)) {
                    onLoginSuccess()
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Please Check your username and password", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(GreenColor),
            contentPadding = PaddingValues(start = 60.dp, end = 60.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Text(
                "Login",
                fontSize = 24.sp
            )
        }
    }
}

private fun authenticate(username: String, password: String): Boolean {
    val validUserName = "admin"
    val validPassword = "admin123"
    return username == validUserName && password == validPassword
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Login"
    ) {
        composable("login") {
            LearnLoginPage(onLoginSuccess = {
                navController.navigate("home") {
                    popUpTo(0)
                }
            })
        }

        composable("home") {
            KHomeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLearnLoginPage() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnLoginPage(onLoginSuccess = {

        })
    }
}