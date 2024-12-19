package com.kishorramani.jetpackcomposeandroidknowledge.i_bottom_sheet

sealed class IScreens(val screen: String) {
    data object Post: IScreens("post")
    data object Home: IScreens("home")
}