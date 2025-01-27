package com.example.mozanmap.data

data class ClassItem(val title: String, val details: List<ClassItem2>)
data class ClassItem2(val title: String, val details: List<String>)

object ClassData { val classItems =
        listOf(
            ClassItem(
                "研究棟A",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("ドーナツラウンジ")
                    ),
                )
            ),
            ClassItem(
                "研究棟B",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("ドーナツラウンジ")
                    ),
                )
            ),
            ClassItem(
                "研究棟C",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "片柳研究棟",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf(
                            "ロボットラボラトリー",
                            "AI実践センター",
                            "デジタルラボラトリー",
                            "バイオナノテクセンター",
                            "デジタルツインセンター"
                        )
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "講義棟A",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf(
                            "インテリアデザイン室",
                            "ゲーム研究・開発ルーム",
                            "キャラクターデザインスタジオ",
                            "デッサン室"
                        )
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "講義棟B",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "講義棟C",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "講義棟D",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "講義棟E",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "講義棟F",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "実験棟A",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("101")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("201", "202")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("301", "302", "303")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "実験棟B(コンピュータ＆テクノロジーセンター)",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf(
                            "高電圧実習室",
                            "一級自動車設備実習場",
                            "無響室",
                            "音響計測実習室",
                            "ロボット制作実習室",
                            "電気機器実習室",
                            "工作・計測・シャシ整備実習室"
                        )
                    ),
                    ClassItem2(
                        "2F",
                        listOf("DTMルーム", "CAD実習室")
                    ),
                    ClassItem2(
                        "3F",
                        listOf(
                            "ゲーム制作スタジオ",
                            "CG制作スタジオ",
                            "MANGA Digital Studio",
                            "HACC Digital Studio"
                        )
                    ),
                    ClassItem2(
                        "4F",
                        listOf("電子工学実習室(エレクトロニクス実験室)")
                    ),
                )
            ),
            ClassItem(
                "スタジオ棟(KCfDA)",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf(
                            "デジタル・オープン・スタジオ",
                            "テレビスタジオ",
                            "レコーディングスタジオ",
                            "モーションキャプチャースタジオ"
                        )
                    ),
                    ClassItem2(
                        "2F",
                        listOf("編集ライン", "テレビスタジオ副調整室(サブコントロールルーム)")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("MAスタジオ", "BOXステージ", "レッスンルーム")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "片柳記念ホール",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf(
                            "アンサンブルスタジオA",
                            "アンサンブルスタジオB",
                            "キーボードルーム",
                            "セッションルーム",
                            "トレーニングルーム"
                        )
                    ),
                    ClassItem2(
                        "2F",
                        listOf("")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "メディアホール",
                listOf(
                    ClassItem2(
                        "B1F",
                        listOf("自動車整備実習棟", "ホール")
                    ),
                    ClassItem2(
                        "1F",
                        listOf("")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("")
                    ),
                )
            ),
            ClassItem(
                "展示棟(AB Studio)",
                listOf(
                    ClassItem2(
                        "1F",
                        listOf("Aスタジオ", "Bスタジオ")
                    ),
                    ClassItem2(
                        "2F",
                        listOf("")
                    ),
                    ClassItem2(
                        "3F",
                        listOf("")
                    ),
                    ClassItem2(
                        "4F",
                        listOf("")
                    ),
                )
            ),
        )
}
//package com.example.mozanmap.data
//
//data class ClassItem(val title: String, val details: List<String>)
//
//object ClassData {
//    val classItems = listOf(
//        ClassItem("研究棟A", listOf("1F","2F","3F","4F","5F","6F","7F","8F","9F","10F","11F","12F")),
//        ClassItem("研究棟B", listOf("1F","2F","3F","4F","5F","6F","7F","8F","9F","10F","11F","12F")),
//        ClassItem("研究棟C", listOf("")),
//        ClassItem("片柳研究棟", listOf("ロボットラボラトリー","AI実践センター","デジタルラボラトリー","バイオナノテクセンター","デジタルツインセンター")),
//        ClassItem("講義棟A", listOf("インテリアデザイン室","ゲーム研究・開発ルーム","キャラクターデザインスタジオ","デッサン室")),
//        ClassItem("講義棟B", listOf("")),
//        ClassItem("講義棟C", listOf("")),
//        ClassItem("講義棟D", listOf("")),
//        ClassItem("講義棟E", listOf("")),
//        ClassItem("講義棟F", listOf("")),
//        ClassItem("実験棟A", listOf("")),
//        ClassItem("実験棟B(コンピュータ＆テクノロジーセンター)", listOf("1F 高電圧実習室","1F 一級自動車設備実習場","1F 無響室","1F 音響計測実習室","1F ロボット制作実習室","1F 電気機器実習室","1F 工作・計測・シャシ整備実習室","2F DTMルーム","2F CAD実習室","3F ゲーム制作スタジオ","3F CG制作スタジオ","3F MANGA Digital Studio","3F HACC Digital Studio","4F 電子工学実習室(エレクトロニクス実験室)")),
//        ClassItem("スタジオ棟(KCfDA)", listOf("1F デジタル・オープン・スタジオ","1F テレビスタジオ","1F レコーディングスタジオ","1F モーションキャプチャースタジオ","2F 編集ライン","2F テレビスタジオ副調整室(サブコントロールルーム)","3F MAスタジオ","3F BOXステージ","3F レッスンルーム")),
//        ClassItem("片柳記念ホール", listOf("アンサンブルスタジオA","アンサンブルスタジオB","キーボードルーム","セッションルーム","トレーニングルーム")),
//        ClassItem("メディアホール", listOf("B1F 自動車整備実習棟","ホール")),
//        ClassItem("展示棟(AB Studio)", listOf("Aスタジオ","Bスタジオ")),
//    )
//}
