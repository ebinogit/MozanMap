package com.example.mozanmap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.FoodInfo
import com.example.mozanmap.data.FoodItem

class FoodAdapter(
    private val items: List<FoodItem>
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.food_container_text)
        val gridView: RecyclerView = itemView.findViewById(R.id.food_container_grid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_food_container, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.title
        // アダプターを設定
        holder.gridView.adapter = FoodItemAdapter(item)
    }
    override fun getItemCount(): Int = items.size
}