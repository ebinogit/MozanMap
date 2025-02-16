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

class OtherAdapter(
    private val otherItems: List<Any>
) : RecyclerView.Adapter<OtherAdapter.OtherViewHolder>() {

    class OtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card:CardView=itemView.findViewById(R.id.class_item_card)
        val imageButton: ImageButton = itemView.findViewById(R.id.class_item_img)
        val textView: TextView = itemView.findViewById(R.id.class_item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_btn, parent, false)
        return OtherViewHolder(view)
    }

    override fun onBindViewHolder(holder: OtherViewHolder, position: Int) {
        when (val item = otherItems[position]) {
            is ClassItem -> {
                Glide.with(holder.imageButton.context)
                    .load(item.imgID)
                    .into(holder.imageButton)
                holder.textView.text = item.title
                // クリックリスナーを設定
                holder.card.setOnClickListener {
                    click2(item.title, holder.itemView)
                }
                holder.imageButton.setOnClickListener {
                    click2(item.title, holder.itemView)
                }
            }
            is OtherItem -> {
                // 画像とテキストを設定
                Glide.with(holder.imageButton.context)
                    .load(item.list[0])
                    .into(holder.imageButton)
                holder.textView.text = item.title
                // クリックリスナーを設定
                holder.card.setOnClickListener {
                    click(item.id, holder.itemView)
                }
                holder.imageButton.setOnClickListener {
                    click(item.id, holder.itemView)
                }
            }
        }
    }
    private fun click(id:Int, view: View) {
        val context = view.context
        val intent = Intent(context, OtherActivity::class.java)
        intent.putExtra("id", id)
        context.startActivity(intent)
    }
    private fun click2(title:String, view: View) {
        val context = view.context
        val intent = Intent(context, ClassActivity::class.java)
        intent.putExtra("title", title)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int = otherItems.size
}