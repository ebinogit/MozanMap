package com.example.mozanmap

import CommentAdapter
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class FoodActivity : AppCompatActivity() {

    private lateinit var commentsRef: DatabaseReference
    private lateinit var usersRef: DatabaseReference
    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var commentAdapter: CommentAdapter
    private val commentList = mutableListOf<String>()
    private val commentKeyMap = mutableMapOf<Int, String>() // コメントとキーの対応付け

    private var isAdmin = false // 管理者判定

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

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
        commentAdapter = CommentAdapter(commentList, onDeleteClicked = { position ->
            if (isAdmin) {
                // インデックスが有効か確認
                if (position >= 0 && position < commentList.size) {
                    val key = commentKeyMap[position]
                    if (key != null) {
                        // Firebaseからコメント削除
                        commentsRef.child(key).removeValue()
                        // ローカルリストから削除
                        commentList.removeAt(position)
                        // キーマップから削除
                        commentKeyMap.remove(position)
                        // RecyclerViewを更新
                        commentAdapter.notifyItemRemoved(position)
                        Toast.makeText(this, "コメントを削除しました", Toast.LENGTH_SHORT).show()

                        // コメントがすべて削除された場合、前の画面に戻らないようにする
                        if (commentList.isEmpty()) {
                            Toast.makeText(this, "コメントがありません", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "無効なインデックスです", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "削除権限がありません", Toast.LENGTH_SHORT).show()
            }
        })
        commentsRecyclerView.layoutManager = LinearLayoutManager(this)
        commentsRecyclerView.adapter = commentAdapter
        commentsRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        // Firebaseの参照を取得
        commentsRef = FirebaseDatabase.getInstance("https://mozanmap-4e6a4-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("comments")
            .child("button_$buttonId")

        usersRef = FirebaseDatabase.getInstance("https://mozanmap-4e6a4-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("users")

        // ユーザーが管理者かどうかを確認
        checkAdminStatus()

        // コメントの読み込み
        loadComments()

        // コメントの保存
        val saveButton = findViewById<Button>(R.id.button_save)
        saveButton.setOnClickListener {
            val updatedComment = commentEditText.text.toString()
            if (updatedComment.isNotEmpty()) {
                commentsRef.push().setValue(updatedComment)
                commentEditText.text.clear()
                Toast.makeText(this, "コメントを保存しました", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "コメントを入力してください", Toast.LENGTH_SHORT).show()
            }
        }

        // 戻るボタン
        val buttonBack = findViewById<ImageButton>(R.id.button_back)
        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun checkAdminStatus() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        currentUser?.let { user ->
            usersRef.child(user.uid).child("isAdmin").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    isAdmin = snapshot.getValue(Boolean::class.java) == true
                    commentAdapter.setAdminStatus(isAdmin)
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@FoodActivity, "管理者権限の確認に失敗しました", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun loadComments() {
        commentsRef.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val comment = snapshot.getValue(String::class.java)
                val key = snapshot.key
                if (comment != null && key != null) {
                    commentList.add(comment)
                    commentKeyMap[commentList.size - 1] = key
                    commentAdapter.notifyDataSetChanged()
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {
                val key = snapshot.key
                if (key != null) {
                    val position = commentKeyMap.values.indexOf(key)
                    if (position >= 0) {
                        commentList.removeAt(position)
                        commentKeyMap.remove(position)
                        commentAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
