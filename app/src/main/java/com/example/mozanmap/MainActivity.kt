package com.example.mozanmap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ButtonData
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonGrid: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BottomSheetBehaviorのセットアップ
        val bottomSheetLayout = findViewById<LinearLayout>(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        // GridLayoutの取得
        buttonGrid = findViewById(R.id.button_grid)

        // ButtonData からボタンリストを取得
        val buttonList = ButtonData.buttonList

        // ボタンを GridLayout に追加
        for (buttonInfo in buttonList) {
            val button = Button(this).apply {
                text = buttonInfo.title
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(buttonInfo.id % 2, 1f) // 列の設定
                    rowSpec = GridLayout.spec(buttonInfo.id / 2) // 行の設定
                }
                setOnClickListener {
                    Log.d("MainActivity", "Button ${buttonInfo.id} clicked")

                    // SubActivity に渡すための Intent を作成
                    val intent = Intent(this@MainActivity, SubActivity::class.java).apply {
                        putExtra("title", buttonInfo.title)
                        putExtra("content", buttonInfo.content)
                        putExtra("imageResId", buttonInfo.imageResId)
                        putExtra("address", buttonInfo.address)
                        putExtra("hours", buttonInfo.hours)
                        putExtra("website", buttonInfo.website)
                        putExtra("phone", buttonInfo.phone)
                    }

                    // SubActivity を開始
                    startActivity(intent)
                }
            }
            buttonGrid.addView(button)
        }
    }
}