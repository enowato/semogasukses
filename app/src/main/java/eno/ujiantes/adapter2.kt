package eno.ujiantes
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.commentview.view.*

class adapter2(val commList: List<Comment>, val context: Context) :
        RecyclerView.Adapter<adapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.commentview,
                parent, false))
    }

    override fun getItemCount(): Int {
        return commList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nama.text = commList.get(position).name
        holder.itemView.email.text = commList.get(position).email
        holder.itemView.komen.text = commList.get(position).body

    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}