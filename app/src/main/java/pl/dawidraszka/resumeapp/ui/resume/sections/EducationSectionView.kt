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

class EducationSectionView @Inject constructor(context: Context, attrs: AttributeSet) :
    SectionView(context, attrs) {

    override fun getSectionName() = R.string.education

    override fun updateData(resume: Resume) {
        hideLoading()
        list_recycler_view.apply {
            layoutManager = NonScrollableLayoutManager(context)
            if (resume.educationSection?.schools != null)
                adapter =
                    ComplexListAdapter(
                        resume.educationSection.schools.sortedByDescending { it.startDateTimestamp }
                    )
        }
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_list, frameLayout)
    }
}