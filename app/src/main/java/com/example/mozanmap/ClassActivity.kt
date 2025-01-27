package com.example.mozanmap

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        // Intent からデータを取得
        val text = intent.getStringExtra("text") ?: "No text provided"
        val imageResId = intent.getIntExtra("imageResId", R.drawable.default_image)

        // レイアウトのビューに設定
        findViewById<ImageView>(R.id.class_view_img).setImageResource(imageResId)
    }
}
