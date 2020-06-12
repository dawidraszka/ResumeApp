package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import kotlinx.android.synthetic.main.item_complex_list.view.*
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_list.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.ui.ComplexListAdapter
import pl.dawidraszka.resumeapp.ui.SimpleListAdapter
import pl.dawidraszka.resumeapp.ui.resume.NonScrollableLayoutManager

class WorkExperienceSectionView(context: Context) : SectionView(context) {

    override fun getSectionName() = R.string.work_experience

    override fun updateData(resume: Resume) {
        list_recycler_view.apply {
            layoutManager = NonScrollableLayoutManager(context)
            if (resume.workExperienceSection?.workExperience != null)
                adapter = ComplexListAdapter(resume.workExperienceSection.workExperience)
        }
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_list, frameLayout)
    }
}