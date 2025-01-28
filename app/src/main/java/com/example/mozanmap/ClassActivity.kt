package com.example.mozanmap

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ClassData

class ClassActivity : AppCompatActivity() {

    private val itemContainer:RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.class_sub_item).apply {
            adapter=ClassSubItemAdapter(ClassData.classItems[0].details)
            setHasFixedSize(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        itemContainer.visibility= View.VISIBLE
        // Intent からデータを取得
        val text = intent.getStringExtra("building") ?: "No text provided"
        val text2 = intent.getStringExtra("floor")

        val test2="$text$text2"

        // レイアウトのビューに設定
        findViewById<TextView>(R.id.class_view_text).text = test2
        findViewById<ImageView>(R.id.class_view_img).setImageResource(ClassData.classItems[0].details[0].imgID)
    }
}
