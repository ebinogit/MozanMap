package com.example.mozanmap.data

import com.example.mozanmap.R

data class OtherItem(
    val id:Int,
    val title: String,
    val img: Int
)

object OtherData {
    val otherItems = listOf(
        OtherItem(0,"プール", R.drawable.kazoo),
        OtherItem(1,"体育館", R.drawable.kazoo),
        OtherItem(2,"図書館", R.drawable.kazoo),
    )
}
