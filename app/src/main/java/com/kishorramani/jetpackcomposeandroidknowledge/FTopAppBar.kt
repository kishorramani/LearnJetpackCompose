package com.kishorramani.jetpackcomposeandroidknowledge

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.GreenColor
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme

class FTopAppBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnTopAppBar()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnTopAppBar() {
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = {
            Text(text = "XPerts")
        },
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context, "XPerts", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(R.drawable.xperts), contentDescription = "XPerts")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenColor,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
            }
            IconButton(onClick = { Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
            }
            IconButton(onClick = { Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu", tint = Color.White)
            }
        }

    )
}

@Preview(showBackground = true)
@Composable
private fun ShowTopAppBar() {
    JetpackComposeAndroidKnowledgeTheme {
        LearnTopAppBar()
    }
}