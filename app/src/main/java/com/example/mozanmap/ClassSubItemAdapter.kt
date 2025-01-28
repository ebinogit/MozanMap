package com.example.mozanmap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ClassItem
import com.example.mozanmap.data.ClassItem2
import com.example.mozanmap.data.ClassItem3

class ClassSubItemAdapter(
    private val classes:List<ClassItem2>
):RecyclerView.Adapter<ClassSubItemAdapter.ClassSubViewHolder>() {

    class ClassSubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageButton = itemView.findViewById(R.id.class_sub_item_img)
        val text: TextView = itemView.findViewById(R.id.class_sub_item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassSubViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sub_class_btn, parent, false)
        return ClassSubViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClassSubViewHolder, position: Int) {
        val item = classes[position]
        holder.img.setImageResource(item.imgID)
        holder.text.text = item.title
        holder.img.setOnClickListener {
//            onItemClick(item.details[position])
        }
    }

    override fun getItemCount(): Int = classes.size
}