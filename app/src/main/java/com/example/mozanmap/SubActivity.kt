package com.example.mozanmap

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // インテントからボタンの内容を受け取る
        val buttonContent = intent.getStringExtra("button_content")

        // TextViewに表示
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = buttonContent ?: "内容がありません" // 内容がない場合のフォールバック
    }
}
