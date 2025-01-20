package com.example.mozanmap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ButtonInfo

class FoodAdapter(private val items: List<ButtonInfo>, private val onItemClick: (ButtonInfo) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    // ViewHolder クラス
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageButton: ImageButton = itemView.findViewById(R.id.image_button)
        val textView: TextView = itemView.findViewById(R.id.image_button_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        // food_img_button レイアウトをインフレート
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_item_btn, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = items[position]

        // 画像とテキストを設定
        holder.imageButton.setImageResource(item.imageResId)
        holder.textView.text = item.title

        // クリックリスナーを設定
        holder.imageButton.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
