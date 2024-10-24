package com.example.mozanmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import android.widget.Button
import androidx.gridlayout.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import android.content.Intent
import android.view.Gravity

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonGrid: GridLayout

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
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED // 初期状態で展開

        // ボタンのクリックイベントの処理
        val buttonOpen = findViewById<ImageButton>(R.id.button_class)
        val buttonClose = findViewById<ImageButton>(R.id.button_food)
        val buttonToSub = findViewById<ImageButton>(R.id.button_others)

        // サブ画面 (SubActivity) へ遷移する
        buttonToSub.setOnClickListener {
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

        // GridLayoutの取得
        buttonGrid = findViewById(R.id.button_grid)

        // ボタンを2列3行で追加する
        val totalButtons = 6  // 2列3行でボタン6個
        for (i in 0 until totalButtons) {
            val button = Button(this).apply {
                text = "Button ${i + 1}"
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0  // 重みを使用するため幅を0に設定
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(i % 2, 1f)  // 列の指定（2列）
                    rowSpec = GridLayout.spec(i / 2)  // 行の指定
                    setGravity(Gravity.FILL_HORIZONTAL)  // 水平方向に埋める
                }
                setOnClickListener {
                    Toast.makeText(this@MainActivity, "Button ${i + 1} clicked!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            buttonGrid.addView(button)  // GridLayoutにボタンを追加
        }
    }
}
