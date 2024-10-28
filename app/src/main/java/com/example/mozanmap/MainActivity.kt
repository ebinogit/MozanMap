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

        // ボタンを追加する (20個)
        val totalButtons = 20
        for (i in 0 until totalButtons) {
            val button = Button(this).apply {
                text = "Button ${i + 1}"
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(i % 2, 1f)
                    rowSpec = GridLayout.spec(i / 2)
                    setGravity(Gravity.FILL_HORIZONTAL)
                }
                setOnClickListener {
                    // 各ボタンがクリックされたときに SubActivity にボタンのインデックスを渡す
                    val intent = Intent(this@MainActivity, SubActivity::class.java)
                    intent.putExtra("button_id", i)
                    startActivity(intent)
                }
            }
            buttonGrid.addView(button)
        }
    }
}
