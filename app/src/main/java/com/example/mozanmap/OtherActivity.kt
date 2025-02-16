package com.example.mozanmap

import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.mozanmap.data.ClassItem
import com.example.mozanmap.data.OtherData
import com.example.mozanmap.data.OtherItem
import com.example.mozanmap.data.OtherItem3

class OtherActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var leftArrow: ImageView
    private lateinit var rightArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        viewPager = findViewById(R.id.photoViewPager)
        leftArrow = findViewById(R.id.leftArrow)
        rightArrow = findViewById(R.id.rightArrow)

        val title = intent.getStringExtra("title")
        val floor = intent.getStringExtra("floor")
        val room = intent.getStringExtra("room")
        val item = OtherData.otherItems
        for(otherItem in item){
            when(otherItem){
                is OtherItem3 -> {
                    if (otherItem.title == title){
                        create(otherItem)
                    }
                }
                is OtherItem -> {
                    if (otherItem.title == title){
                        create(otherItem.details.find { it.title == floor }?.details?.find { it.title == room }!!)
                    }
                }
            }
        }
    }
    private fun create(item: OtherItem3){
        viewPager.adapter = PhotoPagerAdapter(item.list)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                leftArrow.visibility = if (position == 0) View.INVISIBLE else View.VISIBLE
                rightArrow.visibility = if (position == item.list.size - 1) View.INVISIBLE else View.VISIBLE
            }
        })
        leftArrow.setOnClickListener {
            val current = viewPager.currentItem
            if (current > 0) viewPager.currentItem = current - 1
        }
        rightArrow.setOnClickListener {
            val current = viewPager.currentItem
            if (current < item.list.size - 1) viewPager.currentItem = current + 1
        }
        findViewById<TextView>(R.id.other_sub_title).text = item.title
        findViewById<TextView>(R.id.other_sub_information).text = item.information
        //リンクと下線
        val textView = findViewById<TextView>(R.id.linkTextView)
        val spannable = SpannableString(item.linkText)
        spannable.setSpan(UnderlineSpan(), 0, item.linkText.length, 0)
        spannable.setSpan(URLSpan(item.url), 0, item.linkText.length, 0)
        textView.text = spannable
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}
