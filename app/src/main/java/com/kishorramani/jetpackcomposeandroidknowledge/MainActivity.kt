package com.kishorramani.jetpackcomposeandroidknowledge

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.kishorramani.jetpackcomposeandroidknowledge.g_navigation_drawer.GNavigationDrawer
import com.kishorramani.jetpackcomposeandroidknowledge.h_bottom_navigation.GBottomNavigation
import com.kishorramani.jetpackcomposeandroidknowledge.i_bottom_sheet.IBottomSheet
import com.kishorramani.jetpackcomposeandroidknowledge.j_bottom_nav_drawer_sheet.JBottomNavDrawerSheet
import com.kishorramani.jetpackcomposeandroidknowledge.k_login_page.KLoginPage
import com.kishorramani.jetpackcomposeandroidknowledge.l_list_lazy_column_row.LListLazyColumnRow
import com.kishorramani.jetpackcomposeandroidknowledge.m_constraint_layout.MConstraintLayout
import com.kishorramani.jetpackcomposeandroidknowledge.n_navigation_component.NNavigationComponent
import com.kishorramani.jetpackcomposeandroidknowledge.o_mvvm.OMvvm
import com.kishorramani.jetpackcomposeandroidknowledge.p_floating_action_button.PFloatingActionButton
import com.kishorramani.jetpackcomposeandroidknowledge.q_card.QCard
import com.kishorramani.jetpackcomposeandroidknowledge.r_check_boxes.RCheckBox
import com.kishorramani.jetpackcomposeandroidknowledge.s_type_safe_navigation.S1TypeSafeNavigation
import com.kishorramani.jetpackcomposeandroidknowledge.s_type_safe_navigation.S2TypeSafeWithPassArguments
import com.kishorramani.jetpackcomposeandroidknowledge.s_type_safe_navigation.S2TypeSafeWithPassArguments1
import com.kishorramani.jetpackcomposeandroidknowledge.s_type_safe_navigation.S3TypeSafeNestedNavigation
import com.kishorramani.jetpackcomposeandroidknowledge.ui.theme.JetpackComposeAndroidKnowledgeTheme
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    private val activityList = listOf(
        "Text and Modifiers" to ATextAndModifiers::class.java,
        "Row, Column, Box" to BRowColumnBox::class.java,
        "Alignment and Arrangement" to CAlignmentAndArrangement::class.java,
        "Button and Image" to DButtonAndImage::class.java,
        "State" to EState::class.java,
        "Top App Bar" to FTopAppBar::class.java,
        "Navigation Drawer" to GNavigationDrawer::class.java,
        "Bottom Navigation" to GBottomNavigation::class.java,
        "Bottom Sheet" to IBottomSheet::class.java,
        "Bottom Nav + Sheet" to JBottomNavDrawerSheet::class.java,
        "Login Page" to KLoginPage::class.java,
        "List (LazyColumn/Row)" to LListLazyColumnRow::class.java,
        "Constraint Layout" to MConstraintLayout::class.java,
        "Navigation Component" to NNavigationComponent::class.java,
        "MVVM" to OMvvm::class.java,
        "Floating Action Button" to PFloatingActionButton::class.java,
        "Card" to QCard::class.java,
        "Checkboxes" to RCheckBox::class.java,
        "Type-Safe Navigation 1" to S1TypeSafeNavigation::class.java,
        "Type-Safe Navigation 2" to S2TypeSafeWithPassArguments::class.java,
        "Type-Safe Navigation 2.1" to S2TypeSafeWithPassArguments1::class.java,
        "Nested Navigation" to S3TypeSafeNestedNavigation::class.java,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        //splashScreen.setKeepOnScreenCondition { true }
        enableEdgeToEdge()
        setContent {
            JetpackComposeAndroidKnowledgeTheme {
                val context = this@MainActivity  // or just remember it beforehand
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.systemBars.asPaddingValues()),
                    contentAlignment = Alignment.Center,
                ) {
                    MainMenuScreen(activityList, context)
                }
            }
        }
    }
}

@Composable
fun MainMenuScreen(activityList: List<Pair<String, Class<out Activity>>>, context: Context) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(activityList) { item ->
            Button(
                onClick = {
                    val intent = Intent(context, item.second)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = item.first)
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeAndroidKnowledgeTheme {
        Greeting("Android")
    }
}