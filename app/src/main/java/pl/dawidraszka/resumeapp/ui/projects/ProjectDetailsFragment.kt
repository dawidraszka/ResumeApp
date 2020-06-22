package pl.dawidraszka.resumeapp.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_project_details.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.ResumeApplication
import javax.inject.Inject

class ProjectDetailsFragment : Fragment() {
    @Inject
    lateinit var projectDetailsViewModel: ProjectDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext()
        (context.applicationContext as ResumeApplication).appComponent.inject(this)

        return inflater.inflate(R.layout.fragment_project_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(projectDetailsViewModel.getCurrentProject()) {
            if (this != null) {
                name_text_view.text = name
            }
        }
    }
}
