package com.kishorramani.jetpackcomposeandroidknowledge.o_mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OViewModel : ViewModel() {
    var count by mutableStateOf(0)

    fun incrementCounter() {
        count++
    }
}