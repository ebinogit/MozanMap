package com.example.mozanmap

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mozanmap.data.ClassData

class ClassActivity : AppCompatActivity() {

    private lateinit var menuContainer: RecyclerView
    private lateinit var itemContainer: RecyclerView
    private lateinit var textBuilding: TextView
    private lateinit var imgBuilding: ImageView
    private lateinit var imgFloor: ImageView
    private lateinit var buttonBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        menuContainer = findViewById(R.id.class_sub_menu)
        itemContainer = findViewById(R.id.class_sub_item)
        textBuilding = findViewById(R.id.class_view_text)
        imgBuilding = findViewById(R.id.class_sub_img)
        imgFloor = findViewById(R.id.class_view_img)
        buttonBack = findViewById(R.id.button_back)

        // Intent からデータを取得
        val building = intent.getStringExtra("title") ?: "No building provided"
        // 一致する施設を取得
        val selectedBuilding = ClassData.classItems.find { it.title == building }
        //一階を取得
        val firstFloor = selectedBuilding!!.details[0]

        // RecyclerView の初期設定
        val itemAdapter = ClassSubItemAdapter(firstFloor.details)
        itemContainer.apply {
            setHasFixedSize(true)
            adapter = itemAdapter
        }
        val menuAdapter = ClassSubMenuAdapter(selectedBuilding, firstFloor) { menu->
            Log.d("ClassActivity", "Selected menu: $menu")
            val newFloor = selectedBuilding.details.find { it.title == menu }
            Glide.with(this)
                .load(newFloor?.imgID)
                .into(imgFloor)
            itemAdapter.updateData(newFloor!!.details)
        }
        menuContainer.apply {
            setHasFixedSize(true)
            adapter = menuAdapter
        }
        // レイアウトのビューに設定
        textBuilding.text = selectedBuilding.title
        Glide.with(this)
            .load(selectedBuilding.imgID)
            .into(imgBuilding)
        Glide.with(this)
            .load(firstFloor.imgID)
            .into(imgFloor)
        // 戻るボタン
        buttonBack.setOnClickListener {
            finish()
        }
    }
}
