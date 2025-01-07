package com.example.mozanmap.data

import com.example.mozanmap.R

/**
 * ボタン情報のリストを保持するオブジェクト
 */
object ButtonData {
    val buttonList = listOf(
        ButtonInfo(
            id = 0,
            title = "えび",
            content = "えびの情報",
            imageResId = R.drawable.ebiebi,
            address = "東京都渋谷区1-1-1",
            hours = "9:00 - 18:00",
            website = "https://example.com/ebi",
            phone = "080-9876-6408"
        ),
        ButtonInfo(
            id = 1,
            title = "かず",
            content = "かずの情報",
            imageResId = R.drawable.kazoo,
            address = "東京都新宿区2-2-2",
            hours = "10:00 - 20:00",
            website = "https://example.com/kazu",
            phone = "03-9876-5432"
        ),
        ButtonInfo(
            id = 2,
            title = "マクドナルド",
            content = "マクドナルドの情報",
            imageResId = R.drawable.makku,
            address = "",
            hours = "10:00 - 20:00",
            website = "https://example.com/kazu",
            phone = "03-9876-5432"
        ),
        ButtonInfo(
            id = 3,
            title = "マクドナルド",
            content = "マクドナルドの情報",
            imageResId = R.drawable.makku,
            address = "",
            hours = "10:00 - 20:00",
            website = "https://example.com/kazu",
            phone = "03-9876-5432"
        ),
        ButtonInfo(
            id = 4,
            title = "吉野家",
            content = "吉野家の情報",
            imageResId = R.drawable.yoshino,
            address = "",
            hours = "10:00 - 20:00",
            website = "https://www.yoshinoya.com/",
            phone = "03-9876-5432"
        )
    )
}
