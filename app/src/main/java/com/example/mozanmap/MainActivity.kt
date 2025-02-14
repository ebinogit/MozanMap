package com.example.mozanmap

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mozanmap.data.ClassData
import com.example.mozanmap.data.FoodData
import com.example.mozanmap.data.OtherData
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var pinBox: FrameLayout
//    private var pinBoxButtonId=0
    private val classContainer: RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.class_button_container).apply {
            adapter = ClassAdapter(ClassData.classItems)
            setHasFixedSize(true)
        }
    }
    private val foodContainer: View by lazy{
        findViewById<RecyclerView>(R.id.food_button_container).apply {
            adapter = FoodAdapter(FoodData.foodList)
            setHasFixedSize(true)
        }
    }
    private val othersContainer: View by lazy{
        findViewById<RecyclerView>(R.id.others_button_container).apply {
            adapter = OtherAdapter(OtherData.otherItems)
            setHasFixedSize(true)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // BottomSheetBehavior のセットアップ
        val bottomSheetLayout = findViewById<LinearLayout>(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//        setupRecyclerView()
        addPin()
        setupButtonSwitching()
    }
    private fun addPin(){
        pinBox = findViewById(R.id.pinBox)
        val customImageView = findViewById<CustomImageView>(R.id.customImageView)
        var i=0
        while (i < 34) {
            val currentId = i // 現在の i を保存する
            val button = ImageButton(this).also {
                it.id = currentId // 保存した currentId を使用
                it.setBackgroundResource(R.drawable.circle_button)
                Glide.with(this)
                    .load(R.drawable.pin)
                    .into(it)
                val sizeInDp = 80
                val scale = resources.displayMetrics.density
                val sizeInPx = (sizeInDp * scale).toInt() // dp を px に変換
                it.layoutParams = LinearLayout.LayoutParams(sizeInPx, sizeInPx)
                it.scaleType = ImageView.ScaleType.CENTER_INSIDE
                it.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            }
            pinBox.addView(button)
            customImageView.setButton(button.id, button)

            button.setOnClickListener {
//                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//                Log.d("MainActivity", "$currentId, clicked") // currentId を使用
//                if (currentId in 0..14) {
////                    val classContainer = findViewById<View>(R.id.class_button_container)
//                    setupButtonClickListener(R.drawable.class_on, R.drawable.food_img, R.drawable.others_img, classContainer)
//                    val recyclerView = findViewById<RecyclerView>(R.id.class_button_container)
//                    val classAdapter = recyclerView.adapter as? ClassAdapter
//                    classAdapter?.expandItemAt(currentId, true) // インスタンス経由で呼び出す
//                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
//                    layoutManager!!.scrollToPositionWithOffset(currentId, 0)
//                } else {
//                    setupButtonClickListener(R.drawable.class_img, R.drawable.food_img, R.drawable.others_on, othersContainer)
//                }
            }
            i++
        }
    }
    private fun setupButtonSwitching() {
        val classButton = findViewById<ImageButton>(R.id.button_class)
        val foodButton = findViewById<ImageButton>(R.id.button_food)
        val othersButton = findViewById<ImageButton>(R.id.button_others)
        hideAllViews()
        classButton.setOnClickListener{
            setupButtonClickListener(R.drawable.class_on, R.drawable.food_img, R.drawable.others_img, classContainer)
        }
        foodButton.setOnClickListener {
            setupButtonClickListener(R.drawable.class_img, R.drawable.food_on, R.drawable.others_img, foodContainer)
        }
        othersButton.setOnClickListener {
            setupButtonClickListener(R.drawable.class_img, R.drawable.food_img, R.drawable.others_on, othersContainer)
        }
    }
    private fun setupButtonClickListener(classImgResId: Int, foodImgResId: Int, othersImgResId: Int, viewToShow: View) {
        val classButton = findViewById<ImageButton>(R.id.button_class)
        val foodButton = findViewById<ImageButton>(R.id.button_food)
        val othersButton = findViewById<ImageButton>(R.id.button_others)
        Glide.with(this)
            .load(classImgResId)
            .into(classButton)
        Glide.with(this)
            .load(foodImgResId)
            .into(foodButton)
        Glide.with(this)
            .load(othersImgResId)
            .into(othersButton)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        hideAllViews()
        viewToShow.visibility = View.VISIBLE
    }
    private fun hideAllViews() {
        classContainer.visibility = View.GONE
        foodContainer.visibility = View.GONE
        othersContainer.visibility = View.GONE
    }
}
