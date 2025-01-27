package com.example.mozanmap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ClassItem
import com.example.mozanmap.data.OtherItem

class OtherAdapter(
    private val otherItems: List<OtherItem>,
    private val onItemClick: (OtherItem) -> Unit
) : RecyclerView.Adapter<OtherAdapter.OtherViewHolder>() {

    class OtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card:CardView=itemView.findViewById(R.id.other_item_card)
        val imageButton: ImageButton = itemView.findViewById(R.id.other_item_img)
        val textView: TextView = itemView.findViewById(R.id.other_item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_other_btn, parent, false)
        return OtherViewHolder(view)
    }

    override fun onBindViewHolder(holder: OtherViewHolder, position: Int) {
        val item = otherItems[position]

        // 画像とテキストを設定
        holder.imageButton.setImageResource(item.img)
        holder.textView.text = item.title

        // クリックリスナーを設定
        holder.card.setOnClickListener {
            onItemClick(item)
        }
        holder.imageButton.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = otherItems.size
}