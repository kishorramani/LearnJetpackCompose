package com.kishorramani.jetpackcomposeandroidknowledge.q_card

import androidx.annotation.DrawableRes

data class YouTubeData(
    @DrawableRes val thumbnail: Int,
    val videoTitle: String,
    val videoDescription: String
)
