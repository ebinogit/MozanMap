package com.example.mozanmap

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


    class SubActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sub)

            // インテントからデータを取得
            val buttonContent = intent.getStringExtra("button_content")
            val imageResId = intent.getIntExtra("image_res_id", R.drawable.default_image)

            // 取得したデータをログで確認
            Log.d("SubActivity", "Received button content: $buttonContent")
            Log.d("SubActivity", "Received imageResId: $imageResId")

            // TextViewにボタンの内容を表示
            val textView = findViewById<TextView>(R.id.textView)
            textView.text = buttonContent ?: "内容がありません"

            // ImageViewに画像を設定
            val imageView = findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(imageResId)

            // 戻るボタンの設定
            val buttonBack = findViewById<Button>(R.id.button_back)
            buttonBack.setOnClickListener {
                finish()
            }
        }
    }
