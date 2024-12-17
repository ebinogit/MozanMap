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
                // Firebaseに新しいコメントを追加
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
        setContentView(R.layout.activity_main)

        // Firebaseの初期化
        database = FirebaseDatabase.getInstance()
        commentsRef = database.getReference("comments")

        // GridLayoutの取得と列数の設定
        buttonGrid = findViewById(R.id.button_grid)
        buttonGrid.columnCount = 2 // 2列に設定

        // グリッドボタンをセットアップ
        setupGridButtons()
    }

    private fun setupGridButtons() {
        buttonGrid.removeAllViews() // 既存のボタンをすべて削除

        for (buttonInfo in buttonList) {
            val button = Button(this).apply {
                text = buttonInfo.title // ボタンのタイトル
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0 // 重み付けで幅を調整
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f) // 幅を均等配分
                    rowSpec = GridLayout.spec(GridLayout.UNDEFINED) // 自動配置
                }
                tag = buttonInfo.id // IDをタグとして設定
                setOnClickListener {
                    Log.d("MainActivity", "Button ${buttonInfo.id} clicked")

                    // SubActivityに渡すIntentを作成
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

                    // サブ画面を開始
                    editCommentLauncher.launch(intent)
                }
            }
            buttonGrid.addView(button)

            // コメントリスナーを設定
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

                // ボタンのタイトルを buttonList から取得
                val buttonInfo = buttonList.find { it.id == buttonId }
                val buttonTitle = buttonInfo?.title ?: "ボタン$buttonId" // タイトルを取得

                // 最新コメントとコメント件数をボタンに設定
//                val latestComment = if (comments.isNotEmpty()) comments.last() else "コメントなし"
//                button.text = "$buttonTitle: $latestComment (${comments.size}件)"
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MainActivity", "Failed to fetch comments: ${error.message}")
            }
        })
    }
}
