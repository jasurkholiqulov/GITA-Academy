package uz.gita.gitaacademy

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DataAdapter(val data : List<Data>, private var context: Context): RecyclerView.Adapter<DataAdapter.VH>() {
    var itemOnClick : ((Data) -> Unit)? = null

    inner class VH(view : View) : RecyclerView.ViewHolder(view){
        val textAvatar: TextView = view.findViewById(R.id.text_avatar)
        val imageAvatar: ImageView = view.findViewById(R.id.image_avatar)
        val container: FrameLayout = view.findViewById(R.id.container_click)

        init {
            container.setOnClickListener {
                Log.d("TTT","ishladi")

                itemOnClick?.invoke(data[adapterPosition])
            }
        }
    }
    fun itemClickListener(block : (Data) -> Unit){
        itemOnClick = block

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_adapter,parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val item = data[position]
       Picasso.with(context)
           .load(item.resId)
           .resize(600,300)
           .centerCrop()
           .into(holder.imageAvatar)

        holder.textAvatar.text = item.title
    }

    override fun getItemCount(): Int {
       return data.size
    }
}