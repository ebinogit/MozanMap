package com.example.mozanmap

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.FoodInfo

class FoodItemAdapter(
    private val foods: List<FoodInfo>, // 詳細データ
    private val onFoodClick: (FoodInfo) -> Unit // クリック時のコールバック
) : RecyclerView.Adapter<FoodItemAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageButton: ImageButton = itemView.findViewById(R.id.food_item_img)
        val textView: TextView = itemView.findViewById(R.id.food_item_text)    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food_btn, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = foods[position]
        Log.d("food","$position")

        // 画像とテキストを設定
        holder.imageButton.setImageResource(item.imageResId)
        holder.textView.text = item.title

        // クリックリスナーを設定
        holder.imageButton.setOnClickListener {
            onFoodClick(item)
        }
    }

    override fun getItemCount(): Int = foods.size
}
