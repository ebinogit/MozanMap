package com.example.mozanmap.data

data class PinItem(
    val id:Int,
    val title: String,
    val posX: Float,
    val posY: Float
)
object PimData {
    val pinItem = listOf(
        PinItem(0,"研究棟A",1075f,185f),
        PinItem(1,"研究棟B",1330f,185f),
        PinItem(2,"研究棟C",833f,-243f),
        PinItem(3,"片柳研究棟",1395f,1295f),
        PinItem(4,"講義棟A",800f,273f),
        PinItem(5,"講義棟B",1635f,273f),
        PinItem(6,"講義棟C",1515f,83f),
        PinItem(7,"講義棟D",1085f,-30f),
        PinItem(8,"講義棟E",1320f,-30f),
        PinItem(9,"実験棟A",433f,-7f),
        PinItem(10,"実験棟B",1950f,420f),
        PinItem(11,"スタジオ棟",67f,150f),
        PinItem(12,"メディアホール/自動車整備実習場",1990f,185f),
        PinItem(13,"展示棟",1820f,730f),
        PinItem(14,"ものづくり工房",2030f,-210f),
        PinItem(15,"サークル棟",345f,170f),
        PinItem(16,"講義実験棟",823f,83f),

        PinItem(17,"プール",33f,83f),
        PinItem(18,"体育館", -50f,-137f),
        PinItem(19,"図書館棟",1490f,530f),
        PinItem(20,"片柳記念ホール",1160f,-195f),
        PinItem(21,"テニスコート",-327f,47f),
        PinItem(22,"弓道場",390f,-250f),
        PinItem(23,"総合グラウンド",183f,517f),
        PinItem(24,"土木・造園実習場",2285f,-325f),
        PinItem(25,"守衛棟(西門)",2285f,380f),
        PinItem(26,"守衛棟(正門)",1920f,1440f),
        PinItem(27,"多目的グラウンド",1540f,1700f),
        PinItem(28,"クラブハウス",1705f,1810f),
        PinItem(29,"スマートハウス実習棟",740f,1140f),
        PinItem(30,"本部棟",1790f,1035f),

        PinItem(31,"セントラルプラザ",863f,-117f),
        PinItem(32,"厚生棟",930f,520f),
        PinItem(33,"FOODS FUU",920f,730f),
    )
}