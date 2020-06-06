package pl.dawidraszka.resumeapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_complex_list.view.*
import kotlinx.android.synthetic.main.item_simple_list.view.title_text_view
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.sections.Complexable
import pl.dawidraszka.resumeapp.ui.resume.NonScrollableLayoutManager

class ComplexListAdapter(private val items: List<Complexable>) :
    RecyclerView.Adapter<ComplexListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComplexListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ComplexListViewHolder(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(holder: ComplexListViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size
}


class ComplexListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_complex_list, parent, false)) {

    fun bind(item: Complexable) {
        itemView.apply {
            with(item.toComplexItem()) {
                title_text_view.text = title
                dates_text_view.text = dates
                description_text_view.text = description
                details_recycler_view.apply {
                    layoutManager = NonScrollableLayoutManager(context)
                    if (details != null)
                        adapter = SimpleListAdapter(details)
                }
            }
        }
    }
}