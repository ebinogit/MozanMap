package com.example.mozanmap

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mozanmap.data.FoodInfo
import com.example.mozanmap.data.FoodItem

class FoodItemAdapter(
    private val foods: FoodItem
) : RecyclerView.Adapter<FoodItemAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageButton: ImageButton = itemView.findViewById(R.id.food_item_img)
        val textView: TextView = itemView.findViewById(R.id.food_item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_food_btn, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = foods.details[position]
        // 画像とテキストを設定
        Glide.with(holder.itemView.context).load(item.imageResId).into(holder.imageButton)
        holder.textView.text = item.title
        // クリックリスナーを設定
        holder.imageButton.setOnClickListener {
            Log.d("FoodItemAdapter", "Image button clicked: $position")
            val context = it.context
            val intent = Intent(context, FoodActivity::class.java).apply {
                putExtra("build", foods.title)
                putExtra("Id", item.id)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = foods.details.size
}