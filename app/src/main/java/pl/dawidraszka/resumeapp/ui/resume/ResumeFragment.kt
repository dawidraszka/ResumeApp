package pl.dawidraszka.resumeapp.ui.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_resume.*
import kotlinx.android.synthetic.main.fragment_resume.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.ResumeApplication
import pl.dawidraszka.resumeapp.ui.resume.sections.*
import javax.inject.Inject

class ResumeFragment : Fragment() {

    @Inject
    lateinit var resumeViewModel: ResumeViewModel
    lateinit var sectionViews: List<SectionView>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext()
        (context.applicationContext as ResumeApplication).appComponent.inject(this)
        val root = inflater.inflate(R.layout.fragment_resume, container, false)

        sectionViews = listOf(
            root.objective_section_view,
            root.work_experience_section_view,
            root.education_section_view,
            root.skills_section_view,
            root.technical_skills_section_view,
            root.volunteer_work_section_view,
            root.awards_and_honours_section_view,
            root.hobbies_section_view
        )
        
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resumeViewModel.getResume().observe(viewLifecycleOwner, Observer { resume ->
            sectionViews.forEach { it.updateData(resume) }
        })
    }
}
