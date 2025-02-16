package com.example.mozanmap.data

import com.example.mozanmap.R

data class FoodItem(val title: String, val details: List<FoodInfo>)

data class FoodInfo(
    val id: Int,
    val title: String,
    val content: String,
    val imageResId: Int,
    val address: String,
    val hours: String,
    val website: String,
    val phone: String,
)

object FoodData {
    val foodList = listOf(
        FoodItem("厚生棟", listOf(
            FoodInfo(
                id = 0,
                title = "4F ローズキッチン",
                content = "ローズキッチンの情報",
                imageResId = R.drawable.restaurant,
                address = "厚生棟4F",
                hours = "10:00 - 20:00",
                website = "https://example.com/kazu",
                phone = "03-9876-5432"
            ),
            FoodInfo(
                id = 1,
                title = "3F 802TERRACE",
                content = "802　TERRACEの情報",
                imageResId = R.drawable.restaurant,
                address = "厚生棟3F",
                hours = "9:00 - 18:00",
                website = "https://example.com/kazu",
                phone = "03-9876-5432"
            ),
        )),
        FoodItem("セントラルプラザ", listOf(
            FoodInfo(
                id = 2,
                title = "マクドナルド",
                content = "マクドナルドの情報",
                imageResId = R.drawable.makku,
                address = "セントラルプラザ",
                hours = "10:00 - 20:00",
                website = "https://www.mcdonalds.co.jp/",
                phone = "03-9876-5432"
            ),
        )),
        FoodItem("FOODS FUU", listOf(
            FoodInfo(
                id = 3,
                title = "椿家（ラーメン）",
                content = "椿家（ラーメン）の情報",
                imageResId = R.drawable.tsubaki,
                address = "FOODS FUU",
                hours = "10:00 - 20:00",
                website = "https://www.teu.ac.jp/campus/map/daigaku/006621.html",
                phone = "03-9876-5432"
            ),
            FoodInfo(
                id = 4,
                title = "吉野家",
                content = "吉野家の情報",
                imageResId = R.drawable.yoshino,
                address = "FOODS FUU",
                hours = "10:00 - 20:00",
                website = "https://www.yoshinoya.com/",
                phone = "03-9876-5432"
            ),
            FoodInfo(
                id = 5,
                title = "パンだパンダ",
                content = "パンだパンダの情報",
                imageResId = R.drawable.panda,
                address = "FOODS FUU",
                hours = "9:00 - 18:00",
                website = "https://www.teu.ac.jp/campus/map/daigaku/006621.html",
                phone = "03-1234-5678"
            ),
            FoodInfo(
                id = 6,
                title = "セブンイレブン",
                content = "セブンイレブンの情報",
                imageResId = R.drawable.sebun,
                address = "東京都渋谷区1-1-1",
                hours = "9:00 - 18:00",
                website = "https://example.com/ebi",
                phone = "03-1234-5678"
            ),
            FoodInfo(
                id = 7,
                title = "麺や　ともえ屋",
                content = "麺や　ともえ屋",
                imageResId = R.drawable.tomoe,
                address = "FOODS FUU",
                hours = "9:00 - 18:00",
                website = "https://www.teu.ac.jp/campus/map/daigaku/006621.html",
                phone = "03-1234-5678"
            ),
        )),
    )
}