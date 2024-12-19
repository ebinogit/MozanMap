package com.example.mozanmap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import com.example.mozanmap.data.ButtonData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var commentsRef: DatabaseReference
    private lateinit var buttonGrid: GridLayout

    private val buttonList = ButtonData.buttonList

    private val editCommentLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            result.data?.let { data ->
                val buttonId = data.getIntExtra("buttonId", -1)
                val newComment = data.getStringExtra("newComment") ?: ""
                if (buttonId != -1 && newComment.isNotEmpty()) {
                    val commentData = mapOf(
                        "username" to "YourUsername",
                        "text" to newComment,
                        "timestamp" to System.currentTimeMillis()
                    )
                    commentsRef.child("button_$buttonId").push().setValue(commentData)
                    Log.d("MainActivity", "Added new comment for Button $buttonId: $newComment")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Firebase Authentication のインスタンスを取得
        val auth = FirebaseAuth.getInstance()

        // ログイン状態の確認
        if (auth.currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_main)

        // Firebaseの初期化
        database = FirebaseDatabase.getInstance()
        commentsRef = database.getReference("comments")

        // GridLayoutの取得と列数の設定
        buttonGrid = findViewById(R.id.button_grid)
        buttonGrid.columnCount = 2

        // グリッドボタンをセットアップ
        setupGridButtons()
    }

    private fun setupGridButtons() {
        buttonGrid.removeAllViews()

        for (buttonInfo in buttonList) {
            val button = Button(this).apply {
                text = buttonInfo.title
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    rowSpec = GridLayout.spec(GridLayout.UNDEFINED)
                }
                tag = buttonInfo.id
                setOnClickListener {
                    Log.d("MainActivity", "Button ${buttonInfo.id} clicked")

                    val intent = Intent(this@MainActivity, SubActivity::class.java).apply {
                        putExtra("buttonId", buttonInfo.id)
                        putExtra("title", buttonInfo.title)
                        putExtra("content", buttonInfo.content)
                        putExtra("imageResId", buttonInfo.imageResId)
                        putExtra("address", buttonInfo.address)
                        putExtra("hours", buttonInfo.hours)
                        putExtra("website", buttonInfo.website)
                        putExtra("phone", buttonInfo.phone)
                    }
                    editCommentLauncher.launch(intent)
                }
            }
            buttonGrid.addView(button)
            setupCommentListener(buttonInfo.id, button)
        }
    }

    private fun setupCommentListener(buttonId: Int, button: Button) {
        commentsRef.child("button_$buttonId").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val comments = mutableListOf<String>()
                for (child in snapshot.children) {
                    val comment = child.child("text").getValue(String::class.java)
                    comment?.let { comments.add(it) }
                }

                val buttonInfo = buttonList.find { it.id == buttonId }
                val buttonTitle = buttonInfo?.title ?: "ボタン$buttonId"
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MainActivity", "Failed to fetch comments: ${error.message}")
            }
        })
    }
}
