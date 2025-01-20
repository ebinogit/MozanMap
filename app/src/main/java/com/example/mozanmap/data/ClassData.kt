package com.example.mozanmap.data

data class ClassItem(val title: String, val details: List<String>)

object ClassData {
    val classItems = listOf(
        ClassItem("研究棟A", listOf("4F ドーナツラウンジ")),
        ClassItem("研究棟B", listOf("4F ドーナツラウンジ2")),
        ClassItem("研究棟C", listOf("")),
        ClassItem("片柳研究棟", listOf("ロボットラボラトリー","AI実践センター","デジタルラボラトリー","バイオナノテクセンター","デジタルツインセンター")),
        ClassItem("講義棟A", listOf("インテリアデザイン室","ゲーム研究・開発ルーム","キャラクターデザインスタジオ","デッサン室")),
        ClassItem("講義棟B", listOf("")),
        ClassItem("講義棟C", listOf("")),
        ClassItem("講義棟D", listOf("")),
        ClassItem("講義棟E", listOf("")),
        ClassItem("講義棟F", listOf("")),
        ClassItem("実験棟A", listOf("")),
        ClassItem("実験棟B(コンピュータ＆テクノロジーセンター)", listOf("1F 高電圧実習室","1F 一級自動車設備実習場","1F 無響室","1F 音響計測実習室","1F ロボット制作実習室","1F 電気機器実習室","1F 工作・計測・シャシ整備実習室","2F DTMルーム","2F CAD実習室","3F ゲーム制作スタジオ","3F CG制作スタジオ","3F MANGA Digital Studio","3F HACC Digital Studio","4F 電子工学実習室(エレクトロニクス実験室)")),
        ClassItem("スタジオ棟(KCfDA)", listOf("1F デジタル・オープン・スタジオ","1F テレビスタジオ","1F レコーディングスタジオ","1F モーションキャプチャースタジオ","2F 編集ライン","2F テレビスタジオ副調整室(サブコントロールルーム)","3F MAスタジオ","3F BOXステージ","3F レッスンルーム")),
        ClassItem("片柳記念ホール", listOf("アンサンブルスタジオA","アンサンブルスタジオB","キーボードルーム","セッションルーム","トレーニングルーム")),
        ClassItem("メディアホール", listOf("B1F 自動車整備実習棟","ホール")),
        ClassItem("展示棟(AB Studio)", listOf("Aスタジオ","Bスタジオ")),
    )
}
