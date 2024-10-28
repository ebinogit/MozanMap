package com.example.mozanmap

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class SubActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val buttonBack = findViewById<Button>(R.id.button_back)
        val textView = findViewById<TextView>(R.id.textView)  // `textView` を取得

        // ボタンにクリックリスナーを設定
        buttonBack.setOnClickListener {
            // メイン画面に戻る
            finish()  // 現在のアクティビティを終了して、前のアクティビティに戻る
        }

        val buttonId = intent.getIntExtra("button_id", -1)  // ボタンのインデックスを取得
        if (buttonId != -1) {
            // `buttonId` を使用してクリックされたボタンに応じたデータを表示
            textView.text = "ボタン ${buttonId + 1} のコンテンツ"  // `textView` の内容を更新
        }
    }
}
