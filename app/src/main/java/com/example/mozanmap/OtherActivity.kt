package com.example.mozanmap

import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.mozanmap.data.ClassItem
import com.example.mozanmap.data.OtherData
import com.example.mozanmap.data.OtherItem

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val id = intent.getIntExtra("id", -1)
        val items = OtherData.otherItems
        for (item in items) {
            when (item) {
                is OtherItem -> {
                    if (item.id == id) {
                        val viewPager = findViewById<ViewPager2>(R.id.photoViewPager)
                        val leftArrow = findViewById<ImageView>(R.id.leftArrow)
                        val rightArrow = findViewById<ImageView>(R.id.rightArrow)

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
                        //リンクと下線を設定
                        val textView = findViewById<TextView>(R.id.linkTextView)
                        val spannable = SpannableString(item.linkText)
                        spannable.setSpan(UnderlineSpan(), 0, item.linkText.length, 0)
                        spannable.setSpan(URLSpan(item.url), 0, item.linkText.length, 0)
                        textView.text = spannable
                        textView.movementMethod = LinkMovementMethod.getInstance()
                    }
                }
            }
        }
    }
}
