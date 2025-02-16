package com.example.mozanmap.data

import com.example.mozanmap.R

data class OtherItem(
    val id:Int,
    val title: String,
    val information: String,
    val linkText: String,
    val url: String,
    val list: List<Int>
)

object OtherData {
    val otherItems = listOf(
        OtherItem(0,"プール","日本水泳連盟公認、50m×8コースを備えたプール。ダイビング講習なども行われます。","スポーツ・医療カレッジ","https://www.neec.ac.jp/department/sports/",
            listOf(R.drawable.pool,R.drawable.pool2)),
        ClassItem(1,"体育館",R.drawable.toshokan, listOf(
            ClassItem2("1F", R.drawable.no, listOf(
                ClassItem3("メディカルフィットネスセンター(MFC)",R.drawable.medical_fitness_center),
                ClassItem3("テニス場B",R.drawable.arena),
                ClassItem3("テニス場C",R.drawable.arena),
            )),
            ClassItem2("2F", R.drawable.arena, listOf(
                ClassItem3("テニス場A",R.drawable.arena),
                ClassItem3("テニス場B",R.drawable.arena),
                ClassItem3("テニス場C",R.drawable.arena),
            )))),
        OtherItem(2,"図書館","","","",
            listOf(R.drawable.library,R.drawable.library,R.drawable.library))
    )
}
