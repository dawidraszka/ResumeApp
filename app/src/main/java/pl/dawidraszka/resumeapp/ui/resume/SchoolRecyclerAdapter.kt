package pl.dawidraszka.resumeapp.ui.resume.education

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_school.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.sections.education.School

class SchoolRecyclerAdapter (private val schools: List<School>)
    : RecyclerView.Adapter<SchoolViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SchoolViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val school = schools[position]
        holder.bind(school)
    }

    override fun getItemCount(): Int = schools.size

}

class SchoolViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_school, parent, false)) {

    fun bind(school: School) {
        with(school){
            itemView.title_text_view.text = title
            itemView.school_text_view.text = "$name • $city"
            itemView.dates_text_view.text = "$startDate - $endDate"
        }
    }
}