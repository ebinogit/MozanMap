package com.example.mozanmap.data

import com.example.mozanmap.R

data class ClassItem(val title: String, val details: List<ClassItem2>)
data class ClassItem2(val title: String,val imgID:Int, val details: List<ClassItem3>)
data class ClassItem3(val title: String,val imgID:Int)

object ClassData {
    val classItems = listOf(
        ClassItem("研究棟A", listOf(
            ClassItem2("1F", R.drawable.ken_1f, listOf()),
            ClassItem2("2F", R.drawable.ken_2f, listOf()),
            ClassItem2("3F", R.drawable.ken_3f, listOf(
                    ClassItem3("301",R.drawable.default_image),
                    ClassItem3("302",R.drawable.default_image),
                    ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                    ClassItem3("ドーナツラウンジ",R.drawable.default_image))),
            ClassItem2("5F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("6F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("7F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("8F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("9F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("10F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("11F", R.drawable.kenb_11f, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("12F", R.drawable.kenb_12f, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))))),
        ClassItem("研究棟B", listOf(
            ClassItem2("1F", R.drawable.ken_1f, listOf()),
            ClassItem2("2F", R.drawable.ken_2f, listOf()),
            ClassItem2("3F", R.drawable.ken_3f, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image),
                ClassItem3("304",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("ドーナツラウンジ",R.drawable.default_image))))),
        ClassItem("研究棟C", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("101",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("片柳研究棟", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("ロボットラボラトリー",R.drawable.default_image),
                ClassItem3("AI実践センター",R.drawable.default_image),
                ClassItem3("デジタルラボラトリー",R.drawable.default_image),
                ClassItem3("バイオナノテクセンター",R.drawable.default_image),
                ClassItem3("デジタルツインセンター",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("講義棟A", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("インテリアデザイン室",R.drawable.default_image),
                ClassItem3("ゲーム研究・開発ルーム",R.drawable.default_image),
                ClassItem3("キャラクターデザインスタジオ",R.drawable.default_image),
                ClassItem3("デッサン室",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("講義棟B", listOf(
            ClassItem2("1F", R.drawable.koub_1f, listOf(
                ClassItem3("101",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.koub_2f, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("講義棟C", listOf(
            ClassItem2("1F", R.drawable.kouc_1f, listOf(
                ClassItem3("101",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.kouc_2f, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("講義棟D", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("101",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("講義棟E", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("101",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("講義棟F", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("101",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("実験棟A", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("101",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("201",R.drawable.default_image),
                ClassItem3("202",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("301",R.drawable.default_image),
                ClassItem3("302",R.drawable.default_image),
                ClassItem3("303",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("実験棟B(コンピュータ＆テクノロジーセンター)", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("高電圧実習室",R.drawable.default_image),
                ClassItem3("一級自動車設備実習場",R.drawable.default_image),
                ClassItem3("無響室",R.drawable.default_image),
                ClassItem3("音響計測実習室",R.drawable.default_image),
                ClassItem3("ロボット制作実習室",R.drawable.default_image),
                ClassItem3("電気機器実習室",R.drawable.default_image),
                ClassItem3("工作・計測・シャシ整備実習室",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("DTMルーム",R.drawable.default_image),
                ClassItem3("CAD実習室",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("ゲーム制作スタジオ",R.drawable.default_image),
                ClassItem3("CG制作スタジオ",R.drawable.default_image),
                ClassItem3("MANGA Digital Studio",R.drawable.default_image),
                ClassItem3("HACC Digital Studio",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("電子工学実習室(エレクトロニクス実験室)",R.drawable.default_image))))),
        ClassItem("スタジオ棟(KCfDA)", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("デジタル・オープン・スタジオ",R.drawable.default_image),
                ClassItem3("テレビスタジオ",R.drawable.default_image),
                ClassItem3("レコーディングスタジオ",R.drawable.default_image),
                ClassItem3("モーションキャプチャースタジオ",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("編集ライン",R.drawable.default_image),
                ClassItem3("テレビスタジオ副調整室(サブコントロールルーム)",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("MAスタジオ",R.drawable.default_image),
                ClassItem3("BOXステージ",R.drawable.default_image),
                ClassItem3("レッスンルーム",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("スタジオ棟(KCfDA)", listOf(
            ClassItem2("1F", R.drawable.default_image, listOf(
                ClassItem3("アンサンブルスタジオA",R.drawable.default_image),
                ClassItem3("アンサンブルスタジオB",R.drawable.default_image),
                ClassItem3("キーボードルーム",R.drawable.default_image),
                ClassItem3("セッションルーム",R.drawable.default_image),
                ClassItem3("トレーニングルーム",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("メディアホール", listOf(
            ClassItem2("B1F", R.drawable.default_image, listOf(
                ClassItem3("自動車整備実習棟",R.drawable.default_image),
                ClassItem3("ホール",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image))))),
        ClassItem("展示棟(AB Studio)", listOf(
            ClassItem2("B1F", R.drawable.default_image, listOf(
                ClassItem3("Aスタジオ",R.drawable.default_image),
                ClassItem3("Bスタジオ",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image))),
            ClassItem2("2F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image))),
            ClassItem2("3F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image),
                ClassItem3("",R.drawable.default_image))),
            ClassItem2("4F", R.drawable.default_image, listOf(
                ClassItem3("",R.drawable.default_image)
            ))
        ))
    )
}