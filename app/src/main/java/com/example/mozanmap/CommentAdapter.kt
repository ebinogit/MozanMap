package com.example.mozanmap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(
    private val comments: MutableList<FoodActivity.CommentData>,
    private val onDeleteClicked: (position: String) -> Unit
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val commentTextView: TextView = itemView.findViewById(R.id.commentTextView)
        val deleteButton: Button? = itemView.findViewById(R.id.deleteButton)
    }
    private var isAdmin = false // 管理者ステータス

    // 管理者ステータスを設定するメソッド
    fun setAdminStatus(isAdmin: Boolean) {
        this.isAdmin = isAdmin
        notifyDataSetChanged() // ステータス変更時にリストを再描画
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.commentTextView.text = comment.comment
        if (isAdmin) {
            holder.deleteButton?.visibility = View.VISIBLE
            holder.deleteButton?.setOnClickListener {
                onDeleteClicked(comment.key)
            }
        } else {
            holder.deleteButton?.visibility = View.GONE
        }
    }
    override fun getItemCount(): Int = comments.size
}