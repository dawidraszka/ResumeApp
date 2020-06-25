package pl.dawidraszka.resumeapp.ui.projects.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_project_details.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.application.ResumeApplication
import pl.dawidraszka.resumeapp.ui.projects.adapters.ImageListAdapter
import pl.dawidraszka.resumeapp.ui.projects.viewmodels.ProjectDetailsViewModel
import javax.inject.Inject

class ProjectDetailsFragment : Fragment(),
    OnImageClicked {
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
                language_text_view.text = language


                image_recycler_view.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                if (screenshots != null) image_recycler_view.adapter =
                    ImageListAdapter(
                        screenshots,
                        this@ProjectDetailsFragment
                    )

                technologies?.forEachIndexed { index, technology ->
                    if (index % 2 == 0) technologies_used_left_text_view.append("• $technology\n")
                    else technologies_used_right_text_view.append("• $technology\n")
                }

                description_text_view.text = description
                activity?.toolbar?.title = "$name"

                github_button.link = githubLink

                if (googlePlayLink == null) {
                    buttons_linear_layout.removeView(google_play_button)
                } else {
                    google_play_button.link = googlePlayLink
                }
            }
        }
    }

    override fun onClick(index: Int) {
        findNavController().navigate(
            R.id.nav_full_screen_image,
            bundleOf(
                "imageUrls" to projectDetailsViewModel.getCurrentProject()?.screenshots,
                "index" to index
            )
        )
    }
}

interface OnImageClicked {
    fun onClick(index: Int)
}
