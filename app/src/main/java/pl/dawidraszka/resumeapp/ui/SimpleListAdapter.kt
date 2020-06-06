package pl.dawidraszka.resumeapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_simple_list.view.*
import pl.dawidraszka.resumeapp.R

class SimpleListAdapter(private val items: List<String>) :
    RecyclerView.Adapter<SimpleListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SimpleListViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SimpleListViewHolder, position: Int) {
        val item: String = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size
}


class SimpleListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_simple_list, parent, false)) {

    fun bind(item: String) {
        itemView.title_text_view.text = item
    }
}