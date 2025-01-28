package com.example.mozanmap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ClassItem

class ClassItemAdapter(
    private val details: ClassItem, // 詳細データ
    private val onDetailClick: (String,String) -> Unit // クリック時のコールバック
) : RecyclerView.Adapter<ClassItemAdapter.DetailsViewHolder>() {

    class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detailButton: Button = itemView.findViewById(R.id.detail_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_class_detail, parent, false)
        return DetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val detail = details.details[position]
        holder.detailButton.text = detail.title

        // クリックリスナーの設定
        holder.detailButton.setOnClickListener {
            onDetailClick(details.title,detail.title) // コールバックを呼び出す
        }
    }

    override fun getItemCount(): Int = details.title.length
}
