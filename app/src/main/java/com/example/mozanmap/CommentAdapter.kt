import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mozanmap.R

class CommentAdapter(
    private val comments: MutableList<String>,
    private val onDeleteClicked: (position: Int) -> Unit // 削除ボタンがクリックされたときのコールバック
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val commentTextView: TextView = itemView.findViewById(R.id.commentTextView)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.commentTextView.text = comments[position]

        // 削除ボタンのクリックリスナー
        holder.deleteButton.setOnClickListener {
            onDeleteClicked(position) // コールバックを呼び出し
        }
    }

    override fun getItemCount(): Int = comments.size
}
