package com.example.mozanmap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ButtonData
import com.example.mozanmap.data.ClassData
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
        findViewById<RecyclerView>(R.id.food_button_container)
    }
    private val othersContainer: View by lazy{
        findViewById<RecyclerView>(R.id.others_button_container).apply {
//            adapter = ClassAdapter(ClassData.classItems)
//            setHasFixedSize(true)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // BottomSheetBehavior のセットアップ
        val bottomSheetLayout = findViewById<LinearLayout>(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        setupRecyclerView()
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
                it.setImageResource(R.drawable.pin)
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
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                Log.d("MainActivity", "$currentId, clicked") // currentId を使用

                if (currentId == 16 || currentId == 17) {
//                    val classContainer = findViewById<View>(R.id.class_button_container)
                    setupButtonClickListener(R.drawable.class_on, R.drawable.food_img, R.drawable.others_img, classContainer)
                    val classAdapter = findViewById<RecyclerView>(R.id.class_button_container).adapter as? ClassAdapter
                    classAdapter?.expandItemAt(currentId-16, true) // インスタンス経由で呼び出す
                } else {
                    setupButtonClickListener(R.drawable.class_img, R.drawable.food_img, R.drawable.others_on, othersContainer)
                }
            }
            i++
        }
    }
    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.food_button_container)

        // Adapter を設定
        val foodAdapter = FoodAdapter(ButtonData.buttonList) { buttonInfo ->
            // ボタンがクリックされたときの動作
            val intent = Intent(this@MainActivity, FoodActivity::class.java).apply {
                putExtra("buttonId",buttonInfo.id)
                putExtra("title", buttonInfo.title)
                putExtra("content", buttonInfo.content)
                putExtra("imageResId", buttonInfo.imageResId)
                putExtra("address", buttonInfo.address)
                putExtra("hours", buttonInfo.hours)
                putExtra("website", buttonInfo.website)
                putExtra("phone", buttonInfo.phone)
            }
            startActivity(intent)
        }

        recyclerView.adapter = foodAdapter
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
    }private fun setupButtonClickListener(classImgResId: Int, foodImgResId: Int, othersImgResId: Int, viewToShow: View) {
        findViewById<ImageButton>(R.id.button_class).setImageResource(classImgResId)
        findViewById<ImageButton>(R.id.button_food).setImageResource(foodImgResId)
        findViewById<ImageButton>(R.id.button_others).setImageResource(othersImgResId)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        hideAllViews()
        viewToShow.visibility = View.VISIBLE
    }private fun hideAllViews() {
        classContainer.visibility = View.GONE
        foodContainer.visibility = View.GONE
        othersContainer.visibility = View.GONE
    }
}
