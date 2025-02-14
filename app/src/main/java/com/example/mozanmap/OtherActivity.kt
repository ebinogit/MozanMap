package com.example.mozanmap

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mozanmap.data.OtherData

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        // Intent からデータを取得
        val id = intent.getIntExtra("id",-1)
        val item = OtherData.otherItems.find { it.id == id }

        // レイアウトのビューに設定
        findViewById<TextView>(R.id.textView).text = item?.title
        Glide.with(this).load(item?.img).into(findViewById(R.id.otherSubImg))
    }
}
