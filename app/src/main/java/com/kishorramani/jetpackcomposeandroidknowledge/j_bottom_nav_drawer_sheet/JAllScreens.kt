package com.kishorramani.jetpackcomposeandroidknowledge.j_bottom_nav_drawer_sheet

sealed class JAllScreens(val screen: String) {
    data object Home: JAllScreens("home")
    data object Search: JAllScreens("search")
    data object Favorite: JAllScreens("favorite")
    data object Profile: JAllScreens("profile")

    data object Dashboard: JAllScreens("dashboard")
    data object Settings: JAllScreens("settings")
    data object HelpAndSupport: JAllScreens("helpAndSupport")
    data object AboutUs: JAllScreens("aboutUs")

    data object Post: JAllScreens("Post")
}