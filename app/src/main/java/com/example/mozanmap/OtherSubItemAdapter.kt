package com.example.mozanmap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mozanmap.data.OtherItem
import com.example.mozanmap.data.OtherItem2
import com.example.mozanmap.data.OtherItem3

class OtherSubItemAdapter(
    private var building: OtherItem,
    private var floor: OtherItem2
):RecyclerView.Adapter<OtherSubItemAdapter.otherSubViewHolder>() {

    class otherSubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageButton = itemView.findViewById(R.id.item_img)
        val text: TextView = itemView.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): otherSubViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_btn, parent, false)
        return otherSubViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: otherSubViewHolder, position: Int) {
        val item = floor.details[position]
        Glide.with(holder.img.context)
            .load(item.list[0])
//            .override(100, 100) // 必要ならリサイズ
            .into(holder.img)
        holder.text.text = item.title
        holder.img.setOnClickListener {
            click(building.title,floor.title,item.title,it)
        }
        holder.text.setOnClickListener {
            click(building.title,floor.title,item.title,it)
        }
    }
    fun updateData(newDetails: OtherItem2) {
        floor = newDetails
        notifyDataSetChanged() // RecyclerViewを再描画
    }
    private fun click(title:String,floor:String,room:String, view: View) {
        val context = view.context
        val intent = Intent(context, OtherActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("floor", floor)
        intent.putExtra("room", room)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int = floor.details.size
}