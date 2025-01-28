package com.example.mozanmap.data

import com.example.mozanmap.R

data class ClassItem(val title: String, val details: List<ClassItem2>)
data class ClassItem2(val title: String,val imgID:Int, val details: List<ClassItem3>)
data class ClassItem3(val title: String,val imgID:Int)

object ClassData {
    val classItems = listOf(
        ClassItem("研究棟A", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                    ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.kazoo, listOf(
                    ClassItem3("201",R.drawable.kazoo),
                    ClassItem3("202",R.drawable.food_img))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                    ClassItem3("301",R.drawable.ebiebi),
                    ClassItem3("302",R.drawable.ebiebi),
                    ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                    ClassItem3("ドーナツラウンジ",R.drawable.ebiebi))),
            ClassItem2("5F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("6F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))))),
        ClassItem("研究棟B", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("ドーナツラウンジ",R.drawable.ebiebi))))),
        ClassItem("研究棟C", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("片柳研究棟", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("ロボットラボラトリー",R.drawable.ebiebi),
                ClassItem3("AI実践センター",R.drawable.ebiebi),
                ClassItem3("デジタルラボラトリー",R.drawable.ebiebi),
                ClassItem3("バイオナノテクセンター",R.drawable.ebiebi),
                ClassItem3("デジタルツインセンター",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("講義棟A", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("インテリアデザイン室",R.drawable.ebiebi),
                ClassItem3("ゲーム研究・開発ルーム",R.drawable.ebiebi),
                ClassItem3("キャラクターデザインスタジオ",R.drawable.ebiebi),
                ClassItem3("デッサン室",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("講義棟B", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("講義棟C", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("講義棟D", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("講義棟E", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("講義棟F", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("実験棟A", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("101",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("201",R.drawable.ebiebi),
                ClassItem3("202",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("301",R.drawable.ebiebi),
                ClassItem3("302",R.drawable.ebiebi),
                ClassItem3("303",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("実験棟B(コンピュータ＆テクノロジーセンター)", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("高電圧実習室",R.drawable.ebiebi),
                ClassItem3("一級自動車設備実習場",R.drawable.ebiebi),
                ClassItem3("無響室",R.drawable.ebiebi),
                ClassItem3("音響計測実習室",R.drawable.ebiebi),
                ClassItem3("ロボット制作実習室",R.drawable.ebiebi),
                ClassItem3("電気機器実習室",R.drawable.ebiebi),
                ClassItem3("工作・計測・シャシ整備実習室",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("DTMルーム",R.drawable.ebiebi),
                ClassItem3("CAD実習室",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("ゲーム制作スタジオ",R.drawable.ebiebi),
                ClassItem3("CG制作スタジオ",R.drawable.ebiebi),
                ClassItem3("MANGA Digital Studio",R.drawable.ebiebi),
                ClassItem3("HACC Digital Studio",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("電子工学実習室(エレクトロニクス実験室)",R.drawable.ebiebi))))),
        ClassItem("スタジオ棟(KCfDA)", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("デジタル・オープン・スタジオ",R.drawable.ebiebi),
                ClassItem3("テレビスタジオ",R.drawable.ebiebi),
                ClassItem3("レコーディングスタジオ",R.drawable.ebiebi),
                ClassItem3("モーションキャプチャースタジオ",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("編集ライン",R.drawable.ebiebi),
                ClassItem3("テレビスタジオ副調整室(サブコントロールルーム)",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("MAスタジオ",R.drawable.ebiebi),
                ClassItem3("BOXステージ",R.drawable.ebiebi),
                ClassItem3("レッスンルーム",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("スタジオ棟(KCfDA)", listOf(
            ClassItem2("1F", R.drawable.ebiebi, listOf(
                ClassItem3("アンサンブルスタジオA",R.drawable.ebiebi),
                ClassItem3("アンサンブルスタジオB",R.drawable.ebiebi),
                ClassItem3("キーボードルーム",R.drawable.ebiebi),
                ClassItem3("セッションルーム",R.drawable.ebiebi),
                ClassItem3("トレーニングルーム",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("メディアホール", listOf(
            ClassItem2("B1F", R.drawable.ebiebi, listOf(
                ClassItem3("自動車整備実習棟",R.drawable.ebiebi),
                ClassItem3("ホール",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi))))),
        ClassItem("展示棟(AB Studio)", listOf(
            ClassItem2("B1F", R.drawable.ebiebi, listOf(
                ClassItem3("Aスタジオ",R.drawable.ebiebi),
                ClassItem3("Bスタジオ",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi))),
            ClassItem2("2F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi))),
            ClassItem2("3F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi),
                ClassItem3("",R.drawable.ebiebi))),
            ClassItem2("4F", R.drawable.ebiebi, listOf(
                ClassItem3("",R.drawable.ebiebi)
            ))
        ))
    )
}