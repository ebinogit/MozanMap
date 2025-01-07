package com.example.mozanmap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ClassAdapter(private val classItems: List<MainActivity.ClassItem>) : RecyclerView.Adapter<ClassAdapter.ClassViewHolder>() {

    private val expandedState = MutableList(classItems.size) { false }

    class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.class_title)
        val detailsRecyclerView: RecyclerView = itemView.findViewById(R.id.details_recycler_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_class, parent, false)
        return ClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val classItem = classItems[position]

        // タイトルを設定
        holder.titleTextView.text = classItem.title
        // 詳細の表示状態を設定
        holder.detailsRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.detailsRecyclerView.adapter = DetailsAdapter(classItem.details)
        holder.detailsRecyclerView.setHasFixedSize(true)
        holder.detailsRecyclerView.visibility = if (expandedState[position]) View.VISIBLE else View.GONE

        // タイトルがクリックされたら表示状態を切り替える
        holder.titleTextView.setOnClickListener {
            expandedState[position] = !expandedState[position] // 状態を反転
            notifyItemChanged(position) // アイテムを再描画
        }
    }

    override fun getItemCount(): Int = classItems.size
}
