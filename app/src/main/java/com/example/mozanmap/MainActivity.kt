package com.example.mozanmap

import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ButtonInfo
import com.google.android.material.bottomsheet.BottomSheetBehavior

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
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        // GridLayoutの取得
        buttonGrid = findViewById(R.id.button_grid)

        // ボタン情報リスト
        val buttonList = listOf(
            ButtonInfo(0, "えび", "えびの情報", R.drawable.ebiebi),
            ButtonInfo(1, "かず", "かずの情報", R.drawable.kazoo)
            // 他のボタンも同様に定義
        )

        // ボタンを追加
        for (buttonInfo in buttonList) {
            val button = Button(this).apply {
                text = buttonInfo.title  // ボタンのタイトルを設定
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(buttonInfo.id % 2, 1f) // 列の設定
                    rowSpec = GridLayout.spec(buttonInfo.id / 2)  // 行の設定
                }
                setOnClickListener {
                    Log.d("MainActivity", "Button ${buttonInfo.id} clicked, imageResId: ${buttonInfo.imageResId}")

                    // SubActivityに渡すためのIntentを作成
                    val intent = Intent(this@MainActivity, SubActivity::class.java).apply {
                        putExtra("button_content", buttonInfo.content)  // ここはString型
                        putExtra("image_res_id", buttonInfo.imageResId) // ここはInt型
                    }

                    // SubActivityを開始
                    startActivity(intent)
                }
            }
            buttonGrid.addView(button) // GridLayoutにボタンを追加
        }
    }
}
