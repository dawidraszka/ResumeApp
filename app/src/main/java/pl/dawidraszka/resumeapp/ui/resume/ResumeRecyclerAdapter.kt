package pl.dawidraszka.resumeapp.ui.resume

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_school.view.*
import kotlinx.android.synthetic.main.item_section.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.data.model.resume.Section
import pl.dawidraszka.resumeapp.data.model.resume.sections.education.School

class ResumeRecyclerAdapter(private val resume: Resume) :
    RecyclerView.Adapter<ResumeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ResumeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ResumeViewHolder, position: Int) {
        val section = resume.getSections()[position]
        if (section != null) {
            holder.bind(section)
        }
    }

    override fun getItemCount(): Int = resume.getSections().size
}

class ResumeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_section, parent, false)) {

    fun bind(section: Section) {
        with(section) {
            itemView.section_name_text_view.text = name
         /*   itemView.expand_collapse_button.setOnClickListener{
                itemView.to_do_remove_test.visibility = if(itemView.to_do_remove_test.visibility == View.GONE) View.VISIBLE else View.GONE
            }*/
        }
    }
}