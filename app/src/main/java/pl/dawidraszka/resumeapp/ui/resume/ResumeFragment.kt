package pl.dawidraszka.resumeapp.ui.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_resume.view.*
import pl.dawidraszka.resumeapp.EducationSectionView
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.ui.ObjectiveSectionView
import pl.dawidraszka.resumeapp.ui.SectionView

class ResumeFragment : Fragment() {

    private lateinit var resumeViewModel: ResumeViewModel
    private lateinit var sectionViews: List<SectionView>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resumeViewModel = ViewModelProvider(this).get(ResumeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_resume, container, false)

        sectionViews =
            listOf(ObjectiveSectionView(requireContext()), EducationSectionView(requireContext()))
        sectionViews.forEach {
            root.resume_linear_layout.addView(it)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resumeViewModel.getResume().observe(viewLifecycleOwner, Observer { resume ->
            sectionViews.forEach{it.updateData(resume)}
        })
    }
}
