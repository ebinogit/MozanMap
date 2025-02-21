package com.example.mozanmap

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mozanmap.data.OtherData
import com.example.mozanmap.data.OtherItem
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.cardview.widget.CardView

class OtherActivity2 : AppCompatActivity() {

    private lateinit var menuContainer: RecyclerView
    private lateinit var itemContainer: RecyclerView
    private lateinit var textBuilding: TextView
    private lateinit var imgBuilding: ImageView
    private lateinit var imgFloor: ImageView
    private lateinit var buttonBack: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other2)

        menuContainer = findViewById(R.id.other_sub_menu)
        itemContainer = findViewById(R.id.other_sub_item)
        textBuilding = findViewById(R.id.other_view_text)
        imgBuilding = findViewById(R.id.other_sub_img)
        imgFloor = findViewById(R.id.other_view_img)
        buttonBack = findViewById(R.id.button_back)

        // Intent からデータを取得
        val building = intent.getIntExtra("id",-1)
        for(otherItem in OtherData.otherItems){
            when(otherItem){
                is OtherItem -> {
                    if (otherItem.id == building){
                        val itemAdapter = OtherSubItemAdapter(otherItem, otherItem.details[0])
                        itemContainer.apply {
                            setHasFixedSize(true)
                            adapter = itemAdapter
                        }
                        val menuAdapter = OtherSubMenuAdapter(otherItem, otherItem.details[0]) { menu ->
                            val newFloor = otherItem.details.find { it.title == menu }
                            Glide.with(this)
                                .load(newFloor?.imgID)
                                .into(imgFloor)
                            itemAdapter.updateData(newFloor!!)
                        }
                        menuContainer.apply {
                            setHasFixedSize(true)
                            adapter = menuAdapter
                        }
                        // レイアウトのビューに設定
                        textBuilding.text = otherItem.title
                        Glide.with(this)
                            .load(otherItem.imgID)
                            .into(imgBuilding)
                        Glide.with(this)
                            .load(otherItem.details[0].imgID)
                            .into(imgFloor)
                    }
                }
            }
        }
        buttonBack.setOnClickListener {
            finish()
        }
//        // 画面サイズを取得
//        val metrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(metrics)
//        val screenWidth = metrics.widthPixels / metrics.density
//        val screenHeight = metrics.heightPixels / metrics.density
//
//        // 目標のアスペクト比（例: 16:9）
//        val referenceAspectRatio = 16f / 9f
//        val screenAspectRatio = screenWidth / screenHeight
//
//        // 画面サイズに応じた調整関数
//        fun adjustSize(baseDp: Float): Float {
//            return if (screenAspectRatio > referenceAspectRatio) {
//                baseDp * (referenceAspectRatio / screenAspectRatio)
//            } else {
//                baseDp * (screenAspectRatio / referenceAspectRatio)
//            }
//        }
//
//        // dp → px に変換
//        fun Float.toPx(): Int {
//            return TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP, this, resources.displayMetrics
//            ).toInt()
//        }
//
//        // ヘッダーの CardView の高さを調整
//        val headerCard = findViewById<CardView>(R.id.test)
//        val params = headerCard.layoutParams
//        params.height = adjustSize(100f).toPx()
//        headerCard.layoutParams = params
//
//        // メイン画像の CardView の高さを調整
//        val contentCard = findViewById<CardView>(R.id.test2)
//        val contentParams = contentCard.layoutParams
//        contentParams.height = adjustSize(200f).toPx()
//        contentCard.layoutParams = contentParams
//
//        // 戻るボタンのサイズを調整
//        val backButton = findViewById<ImageButton>(R.id.button_back)
//        val backParams = backButton.layoutParams
//        backParams.width = adjustSize(50f).toPx()
//        backParams.height = adjustSize(50f).toPx()
//        backButton.layoutParams = backParams
    }
}