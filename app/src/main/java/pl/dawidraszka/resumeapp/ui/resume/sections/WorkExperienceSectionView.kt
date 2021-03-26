package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import android.util.AttributeSet
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_list.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.ui.resume.NonScrollableLayoutManager
import pl.dawidraszka.resumeapp.ui.resume.adapters.ComplexListAdapter
import javax.inject.Inject

class WorkExperienceSectionView @Inject constructor(context: Context, attrs: AttributeSet) :
    SectionView(context, attrs) {

    override fun getSectionName() = R.string.work_experience

    override fun updateData(resume: Resume) {
        list_recycler_view.apply {
            hideLoading()
            layoutManager = NonScrollableLayoutManager(context)
            if (resume.workExperienceSection?.workExperience != null)
                adapter =
                    ComplexListAdapter(
                        resume.workExperienceSection.workExperience.sortedByDescending { it.startDateTimestamp }
                    )
        }
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_list, frameLayout)
    }
}