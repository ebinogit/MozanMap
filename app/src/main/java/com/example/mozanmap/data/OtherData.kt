package com.example.mozanmap.data

import com.example.mozanmap.R

data class OtherItem(
    val id:Int,
    val title: String,
    val imgID: Int,
    val details: List<OtherItem2>
)
data class OtherItem2(
    val title: String,
    val imgID:Int,
    val details: List<OtherItem3>
)
data class OtherItem3(
    val id:Int,
    val title: String,
    val information: String,
    val linkText: String,
    val url: String,
    val list: List<Int>
)

object OtherData {
    val otherItems = listOf(
        OtherItem3(0,"プール","日本水泳連盟公認、50m×8コースを備えたプール。ダイビング講習なども行われます。","スポーツ・医療カレッジ","https://www.neec.ac.jp/department/sports/", listOf(
                    R.drawable.pool,
                    R.drawable.pool2)),
        OtherItem(1,"体育館",R.drawable.taiikukann, listOf(
            OtherItem2("1F", R.drawable.no, listOf(
                OtherItem3(1,"メディカルフィットネスセンター(MFC)", "スポーツ医学に基づく最新鋭のマシンを備え、科学的トレーニングを行うほか、スポーツクラブの仕事の流れもまるごと学ぶことができます。","スポーツ・医療カレッジ","https://www.neec.ac.jp/department/sports/",listOf(
                    R.drawable.medical_fitness_center)),
                OtherItem3(2,"GEM STONE STUDIO", "ダンスパフォーマンス科トータルプロデューサー・SAMが設計・監修した、ダンスパフォーマンス科専用スタジオ「GEM STONE STUDIO」。最新の音響システムを完備しているほか、スタジオの床はダンスレッスンに適したバネ仕込み仕様。多様なジャンルのダンスレッスンに対応できる、最高の学習環境を実現しています。","ダンスパフォーマンス科","https://www.neec.ac.jp/department/music/dance/",listOf(
                    R.drawable.gem_stone_studio,
                    R.drawable.gem_stone_studio_b)),
                OtherItem3(3,"武道場", "250畳もの広さを誇る武道場は、柔道の授業や柔道部で活用します。","柔道整復科","https://www.neec.ac.jp/department/sports/judoorthopaedics/",listOf(
                    R.drawable.judo_hall)),
                OtherItem3(4,"メディカルフィットネスセンター(MFC)", "","","",listOf(
                    R.drawable.medical_fitness_center)))),
            OtherItem2("2F", R.drawable.no, listOf(
                OtherItem3(5,"稽古場", "声優・演劇科の学生が使用する稽古場。","声優・演劇科","https://www.neec.ac.jp/department/creators/actor/",listOf(
                    R.drawable.rehearsal_hall)))))),
        OtherItem(2,"図書館",R.drawable.library2, listOf(
            OtherItem2("1F",R.drawable.tosho_1f, listOf(
                OtherItem3(6,"入学相談室(広報部)","入学相談、学校見学、入学説明を実施。専任の入学相談スタッフが対応します。","","", listOf(
                    R.drawable.entry_counseling_room)))),
            OtherItem2("2F",R.drawable.tosho_2f, listOf(
                OtherItem3(7,"","","","", listOf(
                    R.drawable.no))
            ))
        ))
    )
}
