package pl.dawidraszka.resumeapp.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_projects.view.*
import pl.dawidraszka.resumeapp.R

class ProjectsFragment : Fragment() {

    private lateinit var projectsViewModel: ProjectsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        projectsViewModel = ViewModelProvider(this).get(ProjectsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_projects, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        projectsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }
}
