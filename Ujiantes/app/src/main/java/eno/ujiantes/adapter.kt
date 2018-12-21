package eno.ujiantes
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.post.view.*

class adapter(val postList: List<Post>, val context: Context) :
        RecyclerView.Adapter<adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.post,
                parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.judul.text = postList.get(position).title
        holder.itemView.isi.text = postList.get(position).body
        holder.itemView.btn1.setOnClickListener{
            val intent = Intent(context, commactivity::class.java)
            intent.putExtra("id",postList.get(position).id)
            startActivity(context,intent,null)
        }

    }
    private fun startnew(){

    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
