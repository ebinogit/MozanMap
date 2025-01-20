package com.example.mozanmap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ButtonData
import com.example.mozanmap.data.ClassData
import com.example.mozanmap.data.getScreenSize
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var pinBox: FrameLayout
    private var pinBoxButtonId = 0
    private val foodGridButtonIdStart = 100 // foodGrid用のボタンID開始番号

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val screenSize = getScreenSize(this)
        Log.d("ScreenSize", "Width: ${screenSize.first}, Height: ${screenSize.second}")

        // BottomSheetBehaviorのセットアップ
        val bottomSheetLayout = findViewById<LinearLayout>(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        pinBox = findViewById(R.id.pinBox)
        val customImageView = findViewById<CustomImageView>(R.id.customImageView)

        // pinBoxのボタンを動的に追加
        repeat(34) { id ->
            val button = ImageButton(this).apply {
                this.id = id
                setBackgroundResource(R.drawable.circle_button)
                setImageResource(R.drawable.pin)
                val sizeInDp = 80
                val scale = resources.displayMetrics.density
                val sizeInPx = (sizeInDp * scale).toInt()
                layoutParams = LinearLayout.LayoutParams(sizeInPx, sizeInPx)
                scaleType = ImageView.ScaleType.CENTER_INSIDE
                importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            }
            pinBox.addView(button)
            customImageView.setButton(button.id, button)
            button.setOnClickListener {
                val intent = Intent(this, SubActivity::class.java).apply {
                    putExtra("buttonId", button.id)
                    putExtra("title", "PinBox Button $id")
                }
                startActivity(intent)
            }
        }

        addClass()
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

    private fun addClass() {
        val recyclerView: RecyclerView = findViewById(R.id.class_button_container)
        recyclerView.adapter = ClassAdapter(ClassData.classItems)
        recyclerView.setHasFixedSize(true)
    }

    private fun addFoods() {
        val buttonList = ButtonData.buttonList
        val foodGrid: GridLayout = findViewById(R.id.food_button_grid)

        buttonList.forEach { buttonInfo ->
            val buttonId = foodGridButtonIdStart + buttonInfo.id
            val button = Button(this).apply {
                text = buttonInfo.title
                id = buttonId
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(buttonInfo.id % 2, 1f)
                    rowSpec = GridLayout.spec(buttonInfo.id / 2)
                }
                setOnClickListener {
                    Log.d("MainActivity", "Button $buttonId clicked")
                    val intent = Intent(this@MainActivity, SubActivity::class.java).apply {
                        putExtra("buttonId", buttonId)
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

        classButton.setOnClickListener {
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
