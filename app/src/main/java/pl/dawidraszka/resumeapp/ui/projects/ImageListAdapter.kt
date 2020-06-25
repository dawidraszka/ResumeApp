package pl.dawidraszka.resumeapp.ui.projects

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_image.view.*
import pl.dawidraszka.resumeapp.R

class ImageListAdapter(private val images: List<String>, private val onImageClicked: OnImageClicked) :
    RecyclerView.Adapter<SimpleListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SimpleListViewHolder(inflater, parent, onImageClicked)
    }

    override fun onBindViewHolder(holder: SimpleListViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size
}


class SimpleListViewHolder(inflater: LayoutInflater, parent: ViewGroup, private val onImageClicked: OnImageClicked) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_image, parent, false)) {

    fun bind(screenUrl: String) {
        Glide.with(itemView)
            .load(screenUrl)
            .into(itemView.image_view)

        itemView.setOnClickListener{onImageClicked.onClick(adapterPosition)}
    }
}