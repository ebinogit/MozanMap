package com.example.mozanmap

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mozanmap.data.ClassData

class ClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        // Intent からデータを取得
        val text = intent.getStringExtra("building") ?: "No text provided"
        val text2 = intent.getStringExtra("floor")

        val test2="$text$text2"

        // レイアウトのビューに設定
        findViewById<TextView>(R.id.class_view_text).text = test2
        findViewById<ImageView>(R.id.class_view_img).setImageResource(ClassData.classItems[0].details[0].imgID)
    }
}
