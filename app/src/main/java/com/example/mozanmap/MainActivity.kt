package com.example.mozanmap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ButtonData
import com.example.mozanmap.data.ClassData
import com.example.mozanmap.data.ClassItem
import com.example.mozanmap.data.getScreenSize
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
//    private lateinit var foodGrid: GridLayout
//    private lateinit var foodGrid: GridLayout
//    private lateinit var foodGrid: GridLayout

    private lateinit var pinBox: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val screenSize = getScreenSize(this)
        Log.d("ScreenSize", "Width: ${screenSize.first}, Height: ${screenSize.second}")
        // BottomSheetBehavior のセットアップ
        val bottomSheetLayout = findViewById<LinearLayout>(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        pinBox = findViewById(R.id.pinBox)

        val customImageView = findViewById<CustomImageView>(R.id.customImageView)
        var i=0
        while (i<34){
            val button=ImageButton(this).also {
                it.id=i
                it.setBackgroundResource(R.drawable.circle_button)
                it.setImageResource(R.drawable.pin)
                val sizeInDp=80
                val scale = resources.displayMetrics.density
                val sizeInPx = (sizeInDp * scale).toInt() // dp を px に変換
                it.layoutParams = LinearLayout.LayoutParams(sizeInPx, sizeInPx)
                it.scaleType = ImageView.ScaleType.CENTER_INSIDE
                it.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            }
            pinBox.addView(button)
            customImageView.setButton(button.id,button)
            button.setOnClickListener {
                val othersContainer = findViewById<View>(R.id.others_button_container)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                setupButtonClickListener(R.drawable.class_img, R.drawable.food_img, R.drawable.others_on, othersContainer)
            }
            i++
        }
//        addClass()
        addFoods()
        setupButtonSwitching()
    }

    private fun hideAllViews() {
        val classContainer = findViewById<View>(R.id.class_button_container)
        val foodContainer = findViewById<View>(R.id.food_button_container)
        val othersContainer = findViewById<View>(R.id.others_button_container)
        classContainer.visibility = View.GONE
        foodContainer.visibility = View.GONE
        othersContainer.visibility = View.GONE
    }
    data class ClassItem(val title: String, val details: List<String>)
//    private fun addClass(){
//        val recyclerView: RecyclerView = findViewById(R.id.class_button_container)
//        recyclerView.adapter = ClassAdapter(ClassData.classItems) // データを取得
//        recyclerView.setHasFixedSize(true)
////        val recyclerView: RecyclerView = findViewById(R.id.class_button_container)
////        val classItems= listOf(
////            ClassItem("Class 1", listOf("Detail 1-1", "Detail 1-2", "Detail 1-3")),
////            ClassItem("Class 2", listOf("Detail 2-1", "Detail 2-2")),
////            ClassItem("Class 3", listOf("Detail 3-1"))
////        )
////        recyclerView.adapter = ClassAdapter(classItems)
//    }

    private fun addFoods() {
        // ButtonData からボタンリストを取得
        val buttonList = ButtonData.buttonList
        val foodGrid:GridLayout = findViewById(R.id.food_button_grid)
        // ボタンを GridLayout に追加
        for (buttonInfo in buttonList) {
            val button = Button(this).apply {
                text = buttonInfo.title
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(buttonInfo.id % 2, 1f) // 列の設定
                    rowSpec = GridLayout.spec(buttonInfo.id / 2) // 行の設定
                }
                setOnClickListener {
                    Log.d("MainActivity", "Button ${buttonInfo.id} clicked")

                    // SubActivity に渡すための Intent を作成
                    val intent = Intent(this@MainActivity, SubActivity::class.java).apply {
                        putExtra("title", buttonInfo.title)
                        putExtra("content", buttonInfo.content)
                        putExtra("imageResId", buttonInfo.imageResId)
                        putExtra("address", buttonInfo.address)
                        putExtra("hours", buttonInfo.hours)
                        putExtra("website", buttonInfo.website)
                        putExtra("phone", buttonInfo.phone)
                    }
                    // SubActivity を開始
                    startActivity(intent)
                }
            }
            foodGrid.addView(button)
        }
    }

    private fun setupButtonSwitching() {
        val classButton = findViewById<ImageButton>(R.id.button_class)
        val foodButton = findViewById<ImageButton>(R.id.button_food)
        val othersButton = findViewById<ImageButton>(R.id.button_others)
        val classContainer = findViewById<View>(R.id.class_button_container)
        val foodContainer = findViewById<View>(R.id.food_button_container)
        val othersContainer = findViewById<View>(R.id.others_button_container)
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
        findViewById<ImageButton>(R.id.button_class).setImageResource(classImgResId)
        findViewById<ImageButton>(R.id.button_food).setImageResource(foodImgResId)
        findViewById<ImageButton>(R.id.button_others).setImageResource(othersImgResId)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        hideAllViews()
        viewToShow.visibility = View.VISIBLE
    }
}
