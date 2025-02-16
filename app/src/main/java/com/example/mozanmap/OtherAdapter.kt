package com.example.mozanmap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mozanmap.data.ClassItem
import com.example.mozanmap.data.OtherItem
import com.example.mozanmap.data.OtherItem3

class OtherAdapter(
    private val otherItems: List<Any>
) : RecyclerView.Adapter<OtherAdapter.OtherViewHolder>() {

    class OtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card:CardView=itemView.findViewById(R.id.class_item_card)
        val imageButton: ImageButton = itemView.findViewById(R.id.item_img)
        val textView: TextView = itemView.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_btn, parent, false)
        return OtherViewHolder(view)
    }

    override fun onBindViewHolder(holder: OtherViewHolder, position: Int) {
        for(otherItem in otherItems){
            when(otherItem){
                is OtherItem3 -> {
                    if (otherItem.id == position){
                        Glide.with(holder.imageButton.context)
                            .load(otherItem.list[0])
                            .into(holder.imageButton)
                        holder.textView.text = otherItem.title
                        holder.card.setOnClickListener {
                            click(otherItem.title, holder.itemView)
                        }
                        holder.imageButton.setOnClickListener {
                            click(otherItem.title, holder.itemView)
                        }
                    }
                }
                is OtherItem -> {
                    if (otherItem.id == position){
                        Glide.with(holder.imageButton.context)
                            .load(otherItem.imgID)
                            .into(holder.imageButton)
                        holder.textView.text = otherItem.title
                        holder.card.setOnClickListener {
                            click2(otherItem.id, holder.itemView)
                        }
                        holder.imageButton.setOnClickListener {
                            click2(otherItem.id, holder.itemView)
                        }
                    }
                }
            }
        }
    }
    private fun click(title:String, view: View) {
        val context = view.context
        val intent = Intent(context, OtherActivity::class.java)
        intent.putExtra("title", title)
        context.startActivity(intent)
    }
    private fun click2(id:Int, view: View) {
        val context = view.context
        val intent = Intent(context, OtherActivity2::class.java)
        intent.putExtra("id", id)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int = otherItems.size
}