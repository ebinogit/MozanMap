package com.example.mozanmap

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailsAdapter(
    private val details: List<String>, // 詳細データ
    private val onDetailClick: (String) -> Unit // クリック時のコールバック
) : RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detailButton: Button = itemView.findViewById(R.id.detail_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
        return DetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val detail = details[position]
        holder.detailButton.text = detail

        // クリックリスナーの設定
        holder.detailButton.setOnClickListener {
            onDetailClick(detail) // コールバックを呼び出す
        }
    }

    override fun getItemCount(): Int = details.size
}
