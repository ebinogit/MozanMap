package com.example.mozanmap

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ClassData
import com.google.android.material.button.MaterialButton

class ClassActivity : AppCompatActivity() {

    private lateinit var menuContainer: RecyclerView
    private lateinit var itemContainer: RecyclerView
    private lateinit var textBuilding: TextView
    private lateinit var imgFloor: ImageView
    private lateinit var imgBuilding: ImageView
    private var selectedMenuIndex: Int? = null // Id を null 許容型にする

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        // RecyclerView の初期化
        itemContainer = findViewById(R.id.class_sub_item)
        menuContainer = findViewById(R.id.class_sub_menu)
        textBuilding = findViewById(R.id.class_view_text)
        imgFloor = findViewById(R.id.class_view_img)
        imgBuilding = findViewById(R.id.class_sub_img)

        // Intent からデータを取得
        val building = intent.getStringExtra("building") ?: "No building provided"
        val floor = intent.getStringExtra("floor") ?: "No floor provided"

        // 条件に一致するデータを取得
        val selectedBuilding = ClassData.classItems.find { it.title == building }
        val selectedFloor = selectedBuilding?.details?.find { it.title == floor }

        if (selectedBuilding == null || selectedFloor == null) {
            Log.e("ClassActivity", "Building or Floor data not found")
            finish()
            return
        }

        // RecyclerView のアダプターを設定
        val itemAdapter = ClassSubItemAdapter(selectedFloor.details)
        itemContainer.adapter = itemAdapter

        menuContainer.adapter = ClassSubMenuAdapter(selectedBuilding, selectedFloor) { menu, id ->
            Log.d("test", "click ClassSubMenu:$menu")
            val newFloor = selectedBuilding.details.find { it.title == menu }
            if (newFloor != null) {
                imgFloor.setImageResource(newFloor.imgID)
                itemAdapter.updateData(newFloor.details)
                selectedMenuIndex = id
            }
        }

        // 初期スクロール位置の設定
        selectedMenuIndex = selectedBuilding.details.indexOf(selectedFloor)
        selectedMenuIndex?.let { index ->
            menuContainer.post {
                (menuContainer.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(index-1, 0)
            }
        }

        // レイアウトのビューに設定
        textBuilding.text = selectedBuilding.title
        imgFloor.setImageResource(selectedFloor.imgID)
        imgBuilding.setImageResource(selectedBuilding.imgID)

        // 戻るボタンの処理
        val buttonBack = findViewById<ImageButton>(R.id.button_back)
        buttonBack.setOnClickListener {
            finish()
        }
    }
}
