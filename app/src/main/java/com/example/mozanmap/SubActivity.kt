package com.example.mozanmap

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class SubActivity : AppCompatActivity() {

    private lateinit var commentsRef: DatabaseReference
    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var commentAdapter: CommentAdapter
    private val commentList = mutableListOf<String>()
    private val commentKeyMap = mutableMapOf<Int, String>() // コメントとキーの対応付け

    private val isAdmin = true // 管理者判定（ここで管理者チェックを行う）

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // インテントからデータを取得
        val buttonId = intent.getIntExtra("buttonId", -1)

        // 各Viewを取得
        val commentEditText = findViewById<EditText>(R.id.commentEditText)
        val saveButton = findViewById<Button>(R.id.button_save)
        val buttonBack = findViewById<ImageButton>(R.id.button_back)

        // RecyclerViewのセットアップ
        commentsRecyclerView = findViewById(R.id.commentsRecyclerView)
        commentAdapter = CommentAdapter(commentList)
        commentsRecyclerView.layoutManager = LinearLayoutManager(this)
        commentsRecyclerView.adapter = commentAdapter
        commentsRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        // Firebaseの参照を取得
        commentsRef = FirebaseDatabase.getInstance("https://mozanmap-4e6a4-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("comments")
            .child("button_$buttonId")

        // コメントの読み込み
        loadComments()

        // コメントの保存
        saveButton.setOnClickListener {
            val updatedComment = commentEditText.text.toString()
            if (updatedComment.isNotEmpty()) {
                commentsRef.push().setValue(updatedComment)
                commentEditText.text.clear()
                Toast.makeText(this, "コメントを保存しました", Toast.LENGTH_SHORT).show()
            }
        }

        // 戻るボタン
        buttonBack.setOnClickListener {
            finish()
        }

        // RecyclerViewの項目スワイプ設定
        if (isAdmin) { // 管理者のみ削除可能
            val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    val key = commentKeyMap[position]
                    if (key != null) {
                        commentsRef.child(key).removeValue() // Firebaseから削除
                    }
                }
            })
            itemTouchHelper.attachToRecyclerView(commentsRecyclerView)
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
