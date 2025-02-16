package com.example.mozanmap

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.OtherItem
import com.example.mozanmap.data.OtherItem2
import com.google.android.material.button.MaterialButton

class OtherSubMenuAdapter(
    private val building: OtherItem,
    private var nowFloor: OtherItem2,
    private val onClick:(String)->Unit
): RecyclerView.Adapter<OtherSubMenuAdapter.ViewHolder>() {

    class ViewHolder(floorView:View):RecyclerView.ViewHolder(floorView){
        val btn: MaterialButton =itemView.findViewById(R.id.class_sub_floor_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_class_sub_floor, parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val floor=building.details[position]
        if(floor.title==nowFloor.title){
            changeButton(holder.btn)
        }else{
            changeButton2(holder.btn)
        }
        holder.btn.text=floor.title
        holder.btn.setOnClickListener{
            val clickFloor=building.details.find { it.title==holder.btn.text }
            nowFloor=clickFloor!!
            notifyDataSetChanged()
            onClick(floor.title)
        }
    }
    private fun changeButton(btn:MaterialButton){
        btn.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FF3232"))
        btn.setTextColor(Color.parseColor("#ffffff"))
    }
    private fun changeButton2(btn: MaterialButton) {
        btn.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFc8c8")) // 背景色
        btn.setTextColor(Color.parseColor("#000000")) // テキスト色
    }
    override fun getItemCount(): Int =building.details.size
}
