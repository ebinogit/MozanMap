package com.example.mozanmap

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class SubActivity : AppCompatActivity() {

    private lateinit var commentsRef: DatabaseReference
    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var commentAdapter: CommentAdapter
    private val commentList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // インテントからデータを取得
        val buttonId = intent.getIntExtra("buttonId", -1)
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val imageResId = intent.getIntExtra("imageResId", R.drawable.default_image)
        val address = intent.getStringExtra("address")
        val hours = intent.getStringExtra("hours")
        val website = intent.getStringExtra("website")
        val phone = intent.getStringExtra("phone")

        // 各Viewを取得
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val contentTextView = findViewById<TextView>(R.id.contentTextView)
        val hoursTextView = findViewById<TextView>(R.id.hoursTextView)
        val websiteTextView = findViewById<TextView>(R.id.websiteTextView)
        val phoneTextView = findViewById<TextView>(R.id.phoneTextView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val commentEditText = findViewById<EditText>(R.id.commentEditText)

        // 取得したデータを各Viewにセット
        titleTextView.text = title ?: "タイトルがありません"
        contentTextView.text = content ?: "内容がありません"
        hoursTextView.text = hours ?: "営業時間がありません"
        websiteTextView.text = website ?: "ウェブサイトがありません"
        phoneTextView.text = phone ?: "電話番号がありません"
        imageView.setImageResource(imageResId)

        // RecyclerViewのセットアップ
        commentsRecyclerView = findViewById(R.id.commentsRecyclerView)
        commentAdapter = CommentAdapter(commentList)
        commentsRecyclerView.layoutManager = LinearLayoutManager(this)
        commentsRecyclerView.adapter = commentAdapter

        // DividerItemDecorationを使用して仕切り線を追加
        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        commentsRecyclerView.addItemDecoration(dividerItemDecoration)

        // Firebaseの参照を取得
        commentsRef = FirebaseDatabase.getInstance().getReference("comments").child("button_$buttonId")

        // Firebaseからコメントを取得
        loadComments()

        // 保存ボタンの設定
        val saveButton = findViewById<Button>(R.id.button_save)
        saveButton.setOnClickListener {
            val updatedComment = commentEditText.text.toString()

            // 新しいコメントをFirebaseに追加
            if (updatedComment.isNotEmpty()) {
                commentsRef.push().setValue(updatedComment)

                // 入力フィールドを空に
                commentEditText.text.clear()

                // 保存完了の通知
                Toast.makeText(this, "コメントを保存しました", Toast.LENGTH_SHORT).show()
            }
        }

        // 戻るボタンの設定
        val buttonBack = findViewById<Button>(R.id.button_back)
        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun loadComments() {
        commentsRef.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val comment = snapshot.getValue(String::class.java)
                comment?.let {
                    commentList.add(it)
                    commentAdapter.notifyDataSetChanged()  // コメント追加後にRecyclerViewを更新
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
