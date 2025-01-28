package com.example.mozanmap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.data.ClassItem

class ClassAdapter(private val classItems: List<ClassItem>) : RecyclerView.Adapter<ClassAdapter.ClassViewHolder>() {

    private val expandedState = MutableList(classItems.size) { false }

    class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.class_title)
        val detailsRecyclerView: RecyclerView = itemView.findViewById(R.id.details_recycler_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_class_text, parent, false)
        return ClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val classItem = classItems[position]
//        val classItem2 = classItem.details[position]

        // タイトル設定
        holder.titleTextView.text = classItem.title

        // 詳細アイテムのRecyclerViewを設定
        holder.detailsRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.detailsRecyclerView.adapter = ClassItemAdapter(classItem) { building, floor ->
            // 詳細アイテムのクリック処理//クリックされた詳細のtextをdetailに渡す
            handleDetailClick(building,floor,holder.itemView)
        }
        holder.detailsRecyclerView.setHasFixedSize(true)

        // 詳細の表示/非表示設定
        holder.detailsRecyclerView.visibility = if (expandedState[position]) View.VISIBLE else View.GONE

        // タイトルクリックで展開状態を切り替え
        holder.titleTextView.setOnClickListener {
            val now = !expandedState[position]
            expandItemAt(position,now)
        }
    }
    override fun getItemCount(): Int = classItems.size

    fun expandItemAt(position: Int, to: Boolean) {
        val previousExpandedPosition = expandedState.indexOf(true) // 現在展開されているアイテムを取得
        if (previousExpandedPosition != -1 && previousExpandedPosition != position) {
            expandedState[previousExpandedPosition] = false
            notifyItemChanged(previousExpandedPosition) // 前回の展開を閉じる
        }
        expandedState[position] = to
        notifyItemChanged(position) // 現在の展開を更新
        println("Clicked text: $position")
    }
    private fun handleDetailClick(building: String,floor: String, view: View) {
        println("Clicked detail: $floor")
        // View の context を利用して Intent を作成
        val context = view.context
        val intent = Intent(context, ClassActivity::class.java).apply {
            putExtra("building", building)
            putExtra("floor", floor)
        }

        // ClassActivity を開始
        context.startActivity(intent)
    }

}
