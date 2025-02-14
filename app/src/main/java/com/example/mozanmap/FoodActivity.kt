package com.example.mozanmap

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mozanmap.data.FoodData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class FoodActivity : AppCompatActivity() {

    data class CommentData(val key: String, val comment: String)

    private lateinit var commentsRef: DatabaseReference
    private lateinit var usersRef: DatabaseReference
    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var commentAdapter: CommentAdapter
    private val dataList = mutableListOf<CommentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        // 各Viewを取得
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val contentTextView = findViewById<TextView>(R.id.contentTextView)
        val hoursTextView = findViewById<TextView>(R.id.hoursTextView)
        val websiteTextView = findViewById<TextView>(R.id.websiteTextView)
        val phoneTextView = findViewById<TextView>(R.id.phoneTextView)
        val imageView = findViewById<ImageView>(R.id.foodSubImg)
        val commentEditText = findViewById<EditText>(R.id.commentEditText)
        commentsRecyclerView = findViewById(R.id.commentsRecyclerView)

        // インテントからデータを取得
        val build = intent.getStringExtra("build")
        val buttonId = intent.getIntExtra("Id", -1)
        val selectedItem = FoodData.foodList.find { it.title == build }?.details?.find { it.id == buttonId }

        // 取得したデータを各Viewにセット
        titleTextView.text = selectedItem?.title
        contentTextView.text = selectedItem?.content
        hoursTextView.text = selectedItem?.hours
        websiteTextView.text = selectedItem?.website
        phoneTextView.text = selectedItem?.phone
        Glide.with(this).load(selectedItem?.imageResId).into(imageView)

        commentsRef = FirebaseDatabase.getInstance()
            .getReference("comments/button_$buttonId")
        commentAdapter = CommentAdapter(dataList){ key ->
            commentsRef.child(key).removeValue()
            Toast.makeText(this, "コメントを削除しました", Toast.LENGTH_SHORT).show()
        }
        commentsRecyclerView.layoutManager = LinearLayoutManager(this)
        commentsRecyclerView.adapter = commentAdapter

        checkAdminStatus()// 管理者権限のチェック

        loadComments()// コメントの読み込み

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
        buttonBack.setOnClickListener { finish() }
    }
    private fun checkAdminStatus() {
        val currentUser = FirebaseAuth.getInstance().currentUser?.uid
        usersRef = FirebaseDatabase.getInstance().getReference("users/$currentUser/isAdmin")
        usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val isAdmin = snapshot.getValue(Boolean::class.java)?: false
//                commentAdapter.setAdminStatus(isAdmin)
                commentAdapter.setAdminStatus(true)
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun loadComments() {
        //データベースの変更を監視
        commentsRef.addChildEventListener(object : ChildEventListener {
            //追加時に呼ばれる
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val comment = snapshot.getValue(String::class.java)
                val key = snapshot.key
                runOnUiThread { // UI スレッドで実行
                    dataList.add(CommentData(key!!, comment!!))
                    commentAdapter.notifyItemInserted(dataList.size - 1)
                }
            }
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            //削除時に呼ばれる
            override fun onChildRemoved(snapshot: DataSnapshot) {
                val key = snapshot.key
                runOnUiThread { // UI スレッドで実行
                    val position = dataList.indexOfFirst { it.key == key }
                    dataList.removeAt(position)
                    commentAdapter.notifyItemRemoved(position)
                    commentAdapter.notifyItemRangeChanged(position, dataList.size - position)
                }
            }
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
    }
}