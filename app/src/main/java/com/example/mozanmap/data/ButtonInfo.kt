package com.example.mozanmap.data

data class ButtonInfo(
    val id: Int,
    val title: String,
    val content: String, // ボタンの内容（String型）
    val imageResId: Int  // 画像リソースID（Int型）
)