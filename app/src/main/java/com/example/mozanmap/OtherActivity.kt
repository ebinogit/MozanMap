package com.example.mozanmap

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        // Intent からデータを取得
        val text = intent.getStringExtra("text") ?: "No text provided"
        val imageResId = intent.getIntExtra("imageResId", R.drawable.default_image)

        // レイアウトのビューに設定
        findViewById<TextView>(R.id.textView).text = text
//        findViewById<ImageView>(R.id.imageView).setImageResource(imageResId)
    }
}
