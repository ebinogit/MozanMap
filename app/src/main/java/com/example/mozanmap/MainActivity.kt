package com.example.mozanmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import android.content.Intent
import android.widget.ImageButton
import com.example.mozanmap.SubActivity

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerViewのセットアップ
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5") // 仮のデータ
        recyclerView.adapter = SimpleAdapter(items)

        // BottomSheetBehaviorのセットアップ
        val bottomSheetLayout = findViewById<LinearLayout>(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)

        // ボタンのクリックイベントの処理
        val buttonOpen = findViewById<ImageButton>(R.id.button_class)
        val buttonClose = findViewById<ImageButton>(R.id.button_food)
        val buttonToSub: ImageButton = findViewById(R.id.button_others)

// ボタンがクリックされたときの処理
        buttonToSub.setOnClickListener {
            // サブ画面 (SubActivity) へ遷移する
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        buttonOpen.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            Toast.makeText(this, "Bottom Sheet Opened", Toast.LENGTH_SHORT).show()
        }

        buttonClose.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            Toast.makeText(this, "Bottom Sheet Closed", Toast.LENGTH_SHORT).show()
        }
    }
}
