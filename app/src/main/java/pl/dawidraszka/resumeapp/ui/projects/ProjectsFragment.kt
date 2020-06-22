package pl.dawidraszka.resumeapp.ui.projects

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_projects.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.ResumeApplication
import pl.dawidraszka.resumeapp.data.model.projects.Project
import pl.dawidraszka.resumeapp.ui.SimpleListAdapter
import javax.inject.Inject

class ProjectsFragment : Fragment(), OnItemClicked {

    @Inject
    lateinit var projectsViewModel: ProjectsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext()
        (context.applicationContext as ResumeApplication).appComponent.inject(this)

        return inflater.inflate(R.layout.fragment_projects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        projects_recycler_view.layoutManager = LinearLayoutManager(context)

        projectsViewModel.getProjects().observe(viewLifecycleOwner, Observer {
            projects_recycler_view.adapter = ProjectsListAdapter(it, this)
        })
    }

    override fun onClick(project: Project) {
        projectsViewModel.setCurrentProject(project)
        findNavController().navigate(R.id.action_nav_projects_to_nav_project_details)
    }
}
