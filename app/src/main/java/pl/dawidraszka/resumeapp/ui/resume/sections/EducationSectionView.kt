package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_complex_list.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume

class EducationSectionView(context: Context) : SectionView(context) {

    override fun getSectionName() = R.string.education

    override fun updateData(resume: Resume) {
        school_test_text_view.text = resume.educationSection?.schools?.get(0)?.name
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_complex_list, frameLayout)
    }
}