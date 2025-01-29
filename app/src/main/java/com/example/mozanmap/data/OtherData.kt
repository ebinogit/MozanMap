package com.example.mozanmap.data

import com.example.mozanmap.R

data class OtherItem(
    val id:Int,
    val title: String,
    val img: Int
)

object OtherData {
    val otherItems = listOf(
        OtherItem(0,"プール", R.drawable.pul),
        OtherItem(1,"体育館", R.drawable.arena),
        OtherItem(2,"図書館", R.drawable.library),
    )
}
