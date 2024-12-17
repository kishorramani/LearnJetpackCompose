package com.kishorramani.jetpackcomposeandroidknowledge.h_bottom_navigation

sealed class HScreens(val screen: String) {
    data object Home: HScreens("home")
    data object Search: HScreens("search")
    data object Profile: HScreens("profile")
    data object Settings: HScreens("settings")
}