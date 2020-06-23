package pl.dawidraszka.resumeapp.ui.projects

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
            parent
        )
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projects[position], onItemClicked)
    }

    override fun getItemCount(): Int = projects.size
}


class ProjectViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_project, parent, false)) {

    fun bind(project: Project, onItemClicked: OnItemClicked) {
        itemView.apply {
            with(project) {
                Glide.with(context)
                    .load("https://is4-ssl.mzstatic.com/image/thumb/Purple123/v4/8c/c9/d4/8cc9d492-6487-0444-741b-8e11dc9c6c1a/pr_source.png/300x0w.jpg")
                    .into(screenshot_1)
                Glide.with(context)
                    .load("https://is4-ssl.mzstatic.com/image/thumb/Purple123/v4/8c/c9/d4/8cc9d492-6487-0444-741b-8e11dc9c6c1a/pr_source.png/300x0w.jpg")
                    .into(screenshot_2)
                Glide.with(context)
                    .load("https://is4-ssl.mzstatic.com/image/thumb/Purple123/v4/8c/c9/d4/8cc9d492-6487-0444-741b-8e11dc9c6c1a/pr_source.png/300x0w.jpg")
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