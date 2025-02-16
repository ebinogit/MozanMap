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
import com.example.mozanmap.data.ClassItem

class ClassAdapter(
    private val classItems: List<ClassItem>
) : RecyclerView.Adapter<ClassAdapter.ClassViewHolder>() {

    class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageButton = itemView.findViewById(R.id.class_item_img)
        val text: TextView = itemView.findViewById(R.id.class_item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_btn, parent, false)
        return ClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        Log.d("test", "test: $position,${classItems.size}")
        val classItem = classItems[position]
        // 設定
        holder.text.text = classItem.title
        Glide.with(holder.image.context)
            .load(classItem.imgID)
            .into(holder.image)
        //クリックリスナー
        holder.text.setOnClickListener {
            clickClass(classItem, holder.itemView)
        }
        holder.image.setOnClickListener {
            clickClass(classItem, holder.itemView)
        }
    }
    override fun getItemCount(): Int = classItems.size
}
private fun clickClass(detail: ClassItem, view: View){
    println("click class:${detail.title}")
    val context = view.context
    val intent = Intent(context, ClassActivity::class.java).apply {
        putExtra("title", detail.title)
        putExtra("imageResId",detail.imgID)
    }
    context.startActivity(intent)
}