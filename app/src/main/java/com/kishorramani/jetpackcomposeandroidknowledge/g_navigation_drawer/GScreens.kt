package com.kishorramani.jetpackcomposeandroidknowledge.g_navigation_drawer

sealed class GScreens(val screen: String) {
    data object Home: GScreens("home")
    data object Profile: GScreens("profile")
    data object Settings: GScreens("settings")
}