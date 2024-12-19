import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.R

class CommentAdapter(
    private val comments: MutableList<String>,
    private val onDeleteClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    private var isAdmin = false // 管理者ステータス

    // 管理者ステータスを設定するメソッド
    fun setAdminStatus(isAdmin: Boolean) {
        this.isAdmin = isAdmin
        notifyDataSetChanged() // ステータス変更時にリストを再描画
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.commentTextView.text = comment

        // 管理者の場合のみ削除ボタンを表示
        if (isAdmin) {
            holder.deleteButton.visibility = View.VISIBLE
            holder.deleteButton.setOnClickListener {
                onDeleteClicked(position)
            }
        } else {
            holder.deleteButton.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val commentTextView: TextView = itemView.findViewById(R.id.commentTextView)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    }
}
