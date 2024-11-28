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
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val imageResId = intent.getIntExtra("imageResId", R.drawable.default_image)
        val address = intent.getStringExtra("address")
        val hours = intent.getStringExtra("hours")
        val website = intent.getStringExtra("website")
        val phone = intent.getStringExtra("phone")

        // 取得したデータをログで確認
        Log.d("SubActivity", "Received title: $title")
        Log.d("SubActivity", "Received content: $content")
        Log.d("SubActivity", "Received imageResId: $imageResId")
        Log.d("SubActivity", "Received address: $address")
        Log.d("SubActivity", "Received hours: $hours")
        Log.d("SubActivity", "Received website: $website")
        Log.d("SubActivity", "Received phone: $phone")

        // 各TextViewとImageViewを取得
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val contentTextView = findViewById<TextView>(R.id.contentTextView)
        //val addressTextView = findViewById<TextView>(R.id.addressTextView)
        val hoursTextView = findViewById<TextView>(R.id.hoursTextView)
        val websiteTextView = findViewById<TextView>(R.id.websiteTextView)
        val phoneTextView = findViewById<TextView>(R.id.phoneTextView)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // 取得したデータを各Viewにセット
        titleTextView.text = title ?: "タイトルがありません"
        contentTextView.text = content ?: "内容がありません"
        //addressTextView.text = address ?: "住所がありません"
        hoursTextView.text = hours ?: "営業時間がありません"
        websiteTextView.text = website ?: "ウェブサイトがありません"
        phoneTextView.text = phone ?: "電話番号がありません"
        imageView.setImageResource(imageResId)

        // 戻るボタンの設定
        val buttonBack = findViewById<Button>(R.id.button_back)
        buttonBack.setOnClickListener {
            finish()
        }
    }
}
