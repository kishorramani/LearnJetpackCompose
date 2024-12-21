package com.kishorramani.jetpackcomposeandroidknowledge.n_navigation_component

sealed class NDestinations(val route: String) {
    data object MainScreen : NDestinations("MainScreen")
    data object HomeScreen : NDestinations("HomeScreen")
}