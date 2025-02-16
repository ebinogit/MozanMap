package com.example.mozanmap

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mozanmap.data.OtherData
import com.example.mozanmap.data.OtherItem

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
    }
}