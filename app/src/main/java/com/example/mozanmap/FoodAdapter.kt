package com.example.mozanmap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.FoodInfo
import com.example.mozanmap.data.FoodItem

class FoodAdapter(private val items: List<FoodItem>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.food_container_text)
        val gridView: RecyclerView = itemView.findViewById(R.id.food_container_grid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food_container, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.title

        // RecyclerView 内に GridLayoutManager を設定
        holder.gridView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(
            holder.itemView.context, 2
        )

        // アダプターを設定
        holder.gridView.adapter = FoodItemAdapter(item.details) { detail ->
            foodSubClick(detail, holder.itemView)
        }
    }

    override fun getItemCount(): Int = items.size
}

private fun foodSubClick(detail: FoodInfo, view: View) {
    val context = view.context
    val intent = Intent(context, FoodActivity::class.java).apply {
        putExtra("buttonId", detail.id)
        putExtra("title", detail.title)
        putExtra("content",detail.content)
        putExtra("imageResId",detail.imageResId)
        putExtra("address",detail.address)
        putExtra("hours",detail.hours)
        putExtra("website",detail.website)
        putExtra("phone",detail.phone)
    }
    println("click food:${detail.title}")
    context.startActivity(intent)
}


//package com.example.mozanmap
//
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageButton
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.mozanmap.data.FoodInfo
//import com.example.mozanmap.data.FoodItem
//
//class FoodAdapter(private val items: List<FoodItem>, private val onItemClick: (FoodItem) -> Unit) :
//    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
//
//    // ViewHolder クラス
//    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imageButton: ImageButton = itemView.findViewById(R.id.image_button)
//        val textView: TextView = itemView.findViewById(R.id.image_button_text)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
//        // food_img_button レイアウトをインフレート
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_food_btn, parent, false)
//        return FoodViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
//        val item = items[position]
//        Log.d("food","$position")
//
//        // 画像とテキストを設定
//        holder.imageButton.setImageResource(item.imageResId)
//        holder.textView.text = item.title
//
//        // クリックリスナーを設定
//        holder.imageButton.setOnClickListener {
//            onItemClick(item)
//        }
//    }
//
//    override fun getItemCount(): Int = items.size
//}
