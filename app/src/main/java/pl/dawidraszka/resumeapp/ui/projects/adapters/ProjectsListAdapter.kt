package pl.dawidraszka.resumeapp.ui.projects.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_project.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.projects.Project

class ProjectsListAdapter(
    private val projects: List<Project>,
    private val onItemClicked: OnItemClicked
) :
    RecyclerView.Adapter<ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProjectViewHolder(
            inflater,
            parent,
            onItemClicked
        )
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projects[position])
    }

    override fun getItemCount(): Int = projects.size
}


class ProjectViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val onItemClicked: OnItemClicked
) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_project, parent, false)) {

    fun bind(project: Project) {
        itemView.apply {
            with(project) {
                Glide.with(context)
                    .load(screenshots?.get(0))
                    .into(screenshot_1)
                Glide.with(context)
                    .load(screenshots?.get(1))
                    .into(screenshot_2)
                Glide.with(context)
                    .load(screenshots?.get(2))
                    .into(screenshot_3)
                name_text_view.text = name
                description_text_view.text = description

                learn_more_button.setOnClickListener {
                    onItemClicked.onClick(project)
                }
            }
        }
    }
}

interface OnItemClicked {
    fun onClick(project: Project)
}