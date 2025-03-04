package com.example.mozanmap.data

import com.example.mozanmap.R

data class ClassItem(val id:Int,val title: String,val imgID: Int, val details: List<ClassItem2>)
data class ClassItem2(val title: String,val imgID:Int, val details: List<ClassItem3>)
data class ClassItem3(val title: String,val imgID:Int)

object ClassData {
    val classItems = listOf(
        ClassItem(0,"研究棟A",R.drawable.kena, listOf(
            ClassItem2("1F", R.drawable.ken_1f, listOf()),
            ClassItem2("2F", R.drawable.ken_2f, listOf()),
            ClassItem2("3F", R.drawable.ken_3f, listOf(
                    ClassItem3("301",R.drawable.ken),
                    ClassItem3("302",R.drawable.ken),
                    ClassItem3("303",R.drawable.ken))),
            ClassItem2("4F", R.drawable.no, listOf()),
            ClassItem2("5F", R.drawable.kena_5f, listOf(
                ClassItem3("501",R.drawable.ken),
                ClassItem3("502",R.drawable.ken),
                ClassItem3("503",R.drawable.ken))),
            ClassItem2("6F", R.drawable.kena_6f, listOf(
                ClassItem3("601",R.drawable.ken),
                ClassItem3("602",R.drawable.ken),
                ClassItem3("603",R.drawable.ken),
                ClassItem3("604",R.drawable.ken),
                ClassItem3("605",R.drawable.ken),
                ClassItem3("606",R.drawable.ken),
                ClassItem3("607",R.drawable.ken),
                ClassItem3("608",R.drawable.ken),
                ClassItem3("609",R.drawable.ken),
                ClassItem3("610",R.drawable.ken),
                ClassItem3("611",R.drawable.ken),
                ClassItem3("612",R.drawable.ken),
                ClassItem3("613",R.drawable.ken))),
            ClassItem2("7F", R.drawable.kena_7f, listOf(
                ClassItem3("701",R.drawable.ken),
                ClassItem3("702",R.drawable.ken),
                ClassItem3("703",R.drawable.ken),
                ClassItem3("704",R.drawable.ken),
                ClassItem3("705",R.drawable.ken),
                ClassItem3("706",R.drawable.ken),
                ClassItem3("707",R.drawable.ken),
                ClassItem3("708",R.drawable.ken),
                ClassItem3("709",R.drawable.ken),
                ClassItem3("710",R.drawable.ken),
                ClassItem3("711",R.drawable.ken),
                ClassItem3("712",R.drawable.ken),
                ClassItem3("713",R.drawable.ken))),
            ClassItem2("8F", R.drawable.kena_8f, listOf(
                ClassItem3("801",R.drawable.ken),
                ClassItem3("802",R.drawable.ken),
                ClassItem3("803",R.drawable.ken),
                ClassItem3("804",R.drawable.ken),
                ClassItem3("805",R.drawable.ken),
                ClassItem3("806",R.drawable.ken),
                ClassItem3("807",R.drawable.ken),
                ClassItem3("808",R.drawable.ken),
                ClassItem3("809",R.drawable.ken),
                ClassItem3("810",R.drawable.ken),
                ClassItem3("811",R.drawable.ken),
                ClassItem3("812",R.drawable.ken),
                ClassItem3("813",R.drawable.ken),
                ClassItem3("814",R.drawable.ken),
                ClassItem3("815",R.drawable.ken),
                ClassItem3("816",R.drawable.ken),
                ClassItem3("817",R.drawable.ken))),
            ClassItem2("9F", R.drawable.no, listOf(
                ClassItem3("901",R.drawable.ken),
                ClassItem3("902",R.drawable.ken),
                ClassItem3("903",R.drawable.ken),
                ClassItem3("904",R.drawable.ken),
                ClassItem3("905-1",R.drawable.ken),
                ClassItem3("905-2",R.drawable.ken),
                ClassItem3("905-3",R.drawable.ken),
                ClassItem3("905-4",R.drawable.ken),
                ClassItem3("906",R.drawable.ken),
                ClassItem3("907-1",R.drawable.ken),
                ClassItem3("907-2",R.drawable.ken),
                ClassItem3("907-3",R.drawable.ken),
                ClassItem3("907-4",R.drawable.ken),
                ClassItem3("908",R.drawable.ken),
                ClassItem3("909",R.drawable.ken),
                ClassItem3("910",R.drawable.ken),
                ClassItem3("911",R.drawable.ken),
                ClassItem3("912",R.drawable.ken))),
            ClassItem2("10F", R.drawable.kena_10f, listOf(
                ClassItem3("1001",R.drawable.ken),
                ClassItem3("1002",R.drawable.ken),
                ClassItem3("1003",R.drawable.ken),
                ClassItem3("1004",R.drawable.ken),
                ClassItem3("1005",R.drawable.ken),
                ClassItem3("1006",R.drawable.ken),
                ClassItem3("1007",R.drawable.ken),
                ClassItem3("1008",R.drawable.ken),
                ClassItem3("1009",R.drawable.ken),
                ClassItem3("1010",R.drawable.ken),
                ClassItem3("1011",R.drawable.ken),
                ClassItem3("1012",R.drawable.ken),
                ClassItem3("1013",R.drawable.ken),
                ClassItem3("1014",R.drawable.ken),
                ClassItem3("1015",R.drawable.ken),
                ClassItem3("1016",R.drawable.ken),
                ClassItem3("1017",R.drawable.ken))),
            ClassItem2("11F", R.drawable.kena_11f, listOf(
                ClassItem3("1101",R.drawable.ken),
                ClassItem3("1102",R.drawable.ken),
                ClassItem3("1103",R.drawable.ken),
                ClassItem3("1104",R.drawable.ken),
                ClassItem3("1105",R.drawable.ken),
                ClassItem3("1106",R.drawable.ken),
                ClassItem3("1107",R.drawable.ken),
                ClassItem3("1108",R.drawable.ken),
                ClassItem3("1109",R.drawable.ken),
                ClassItem3("1110",R.drawable.ken),
                ClassItem3("1111",R.drawable.ken),
                ClassItem3("1112",R.drawable.ken))),
            ClassItem2("12F", R.drawable.kena_12f, listOf(
                ClassItem3("1201",R.drawable.ken),
                ClassItem3("1202",R.drawable.ken),
                ClassItem3("1203",R.drawable.ken),
                ClassItem3("1204",R.drawable.ken),
                ClassItem3("1205",R.drawable.ken),
                ClassItem3("1206",R.drawable.ken),
                ClassItem3("1207",R.drawable.ken),
                ClassItem3("1208",R.drawable.ken),
                ClassItem3("1209",R.drawable.ken),
                ClassItem3("1211",R.drawable.ken),
                ClassItem3("1212",R.drawable.ken),
                ClassItem3("1213",R.drawable.ken))))),
        ClassItem(1,"研究棟B",R.drawable.kenb, listOf(
            ClassItem2("1F", R.drawable.ken_1f, listOf()),
            ClassItem2("2F", R.drawable.ken_2f, listOf()),
            ClassItem2("3F", R.drawable.ken_3f, listOf(
                ClassItem3("301",R.drawable.ken),
                ClassItem3("302",R.drawable.ken),
                ClassItem3("303",R.drawable.ken),
                ClassItem3("304",R.drawable.ken))),
            ClassItem2("4F", R.drawable.kenb_4f, listOf()),
            ClassItem2("5F", R.drawable.kenb_5f, listOf(
                ClassItem3("501",R.drawable.ken),
                ClassItem3("502",R.drawable.ken))),
            ClassItem2("6F", R.drawable.kenb_6f, listOf()),
            ClassItem2("7F", R.drawable.kenb_7f, listOf()),
            ClassItem2("8F", R.drawable.kenb_8f, listOf()),
            ClassItem2("9F", R.drawable.kenb_9f, listOf(
                ClassItem3("901",R.drawable.ken),
                ClassItem3("902",R.drawable.ken),
                ClassItem3("903",R.drawable.ken),
                ClassItem3("904",R.drawable.ken))),
            ClassItem2("10F", R.drawable.kenb_10f, listOf()),
            ClassItem2("11F", R.drawable.kenb_11f, listOf(
                ClassItem3("1101",R.drawable.ken),
                ClassItem3("1102",R.drawable.ken),
                ClassItem3("1103",R.drawable.ken),
                ClassItem3("1104",R.drawable.ken),
                ClassItem3("1105",R.drawable.ken),
                ClassItem3("1106",R.drawable.ken),
                ClassItem3("1107",R.drawable.ken),
                ClassItem3("1108",R.drawable.ken),
                ClassItem3("1109",R.drawable.ken),
                ClassItem3("1110",R.drawable.ken),
                ClassItem3("1111",R.drawable.ken),
                ClassItem3("1112",R.drawable.ken))),
            ClassItem2("12F", R.drawable.kenb_12f, listOf(
                ClassItem3("1201",R.drawable.kenb_1201),
                ClassItem3("1202",R.drawable.kenb_1202),
                ClassItem3("1203",R.drawable.kenb_1203),
                ClassItem3("1204",R.drawable.kenb_1204),
                ClassItem3("1205",R.drawable.kenb_1205),
                ClassItem3("1206",R.drawable.kenb_1206),
                ClassItem3("1207",R.drawable.kenb_1207),
                ClassItem3("1208",R.drawable.kenb_1208),
                ClassItem3("1209",R.drawable.kenb_1209),
                ClassItem3("1211",R.drawable.kenb_1210),
                ClassItem3("1212",R.drawable.kenb_1211),
                ClassItem3("1213",R.drawable.kenb_1212))))),
        ClassItem(2,"研究棟C",R.drawable.kenc, listOf(
            ClassItem2("1F", R.drawable.no, listOf()))),
        ClassItem(3,"片柳研究棟",R.drawable.katayanagiken, listOf(
            ClassItem2("?F", R.drawable.no, listOf(
                ClassItem3("ロボットラボラトリー",R.drawable.no),
                ClassItem3("AI実践センター",R.drawable.no),
                ClassItem3("デジタルラボラトリー",R.drawable.no),
                ClassItem3("バイオナノテクセンター",R.drawable.no),
                ClassItem3("デジタルツインセンター",R.drawable.no))))),
        ClassItem(4,"講義棟A",R.drawable.koua, listOf(
            ClassItem2("?F", R.drawable.no, listOf(
                ClassItem3("インテリアデザイン室",R.drawable.no),
                ClassItem3("ゲーム研究・開発ルーム",R.drawable.no),
                ClassItem3("キャラクターデザインスタジオ",R.drawable.no),
                ClassItem3("デッサン室",R.drawable.no))))),
        ClassItem(5,"講義棟B",R.drawable.kou, listOf(
            ClassItem2("1F", R.drawable.koub_1f, listOf()),
            ClassItem2("2F", R.drawable.koub_2f, listOf(
                ClassItem3("201",R.drawable.ken),
                ClassItem3("202",R.drawable.ken),
                ClassItem3("203",R.drawable.ken),
                ClassItem3("204",R.drawable.ken),
                ClassItem3("205",R.drawable.ken),
                ClassItem3("206",R.drawable.ken),
                ClassItem3("207",R.drawable.ken),
                ClassItem3("208",R.drawable.ken),
                ClassItem3("209",R.drawable.ken))))),
        ClassItem(6,"講義棟C",R.drawable.kouc, listOf(
            ClassItem2("1F", R.drawable.kouc_1f, listOf(
                ClassItem3("101",R.drawable.ken),
                ClassItem3("102",R.drawable.ken))),
            ClassItem2("2F", R.drawable.kouc_2f, listOf(
                ClassItem3("201",R.drawable.ken),
                ClassItem3("202",R.drawable.ken),
                ClassItem3("203",R.drawable.ken),
                ClassItem3("204",R.drawable.ken),
                ClassItem3("205",R.drawable.ken),
                ClassItem3("206",R.drawable.ken),
                ClassItem3("207",R.drawable.ken),
                ClassItem3("208",R.drawable.ken),
                ClassItem3("209",R.drawable.ken),
                ClassItem3("210",R.drawable.ken))))),
        ClassItem(7,"講義棟D",R.drawable.koud, listOf()),
        ClassItem(8,"講義棟E", R.drawable.koujikken,listOf()),
        ClassItem(9,"実験棟A",R.drawable.kena, listOf()),
        ClassItem(10,"実験棟B(コンピュータ＆テクノロジーセンター)",R.drawable.kenb, listOf(
            ClassItem2("1F", R.drawable.no, listOf(
                ClassItem3("高電圧実習室",R.drawable.no),
                ClassItem3("一級自動車設備実習場",R.drawable.no),
                ClassItem3("無響室",R.drawable.no),
                ClassItem3("音響計測実習室",R.drawable.no),
                ClassItem3("ロボット制作実習室",R.drawable.no),
                ClassItem3("電気機器実習室",R.drawable.no),
                ClassItem3("工作・計測・シャシ整備実習室",R.drawable.no))),
            ClassItem2("2F", R.drawable.no, listOf(
                ClassItem3("DTMルーム",R.drawable.dtm_room),
                ClassItem3("CAD実習室",R.drawable.no))),
            ClassItem2("3F", R.drawable.no, listOf(
                ClassItem3("ゲーム制作スタジオ",R.drawable.no),
                ClassItem3("CG制作スタジオ",R.drawable.no),
                ClassItem3("MANGA Digital Studio",R.drawable.no),
                ClassItem3("HACC Digital Studio",R.drawable.no))),
            ClassItem2("4F", R.drawable.no, listOf(
                ClassItem3("電子工学実習室(エレクトロニクス実験室)",R.drawable.no))))),
        ClassItem(11,"スタジオ棟(KCfDA)",R.drawable.sutajio, listOf(
            ClassItem2("1F", R.drawable.no, listOf(
                ClassItem3("デジタル・オープン・スタジオ",R.drawable.no),
                ClassItem3("テレビスタジオ",R.drawable.no),
                ClassItem3("レコーディングスタジオ",R.drawable.no),
                ClassItem3("モーションキャプチャースタジオ",R.drawable.no))),
            ClassItem2("2F", R.drawable.no, listOf(
                ClassItem3("編集ライン",R.drawable.no),
                ClassItem3("テレビスタジオ副調整室(サブコントロールルーム)",R.drawable.no))),
            ClassItem2("3F", R.drawable.no, listOf(
                ClassItem3("MAスタジオ",R.drawable.no),
                ClassItem3("BOXステージ",R.drawable.no),
                ClassItem3("レッスンルーム",R.drawable.no))),
            ClassItem2("4F", R.drawable.no, listOf(
                ClassItem3("",R.drawable.no))))))
}