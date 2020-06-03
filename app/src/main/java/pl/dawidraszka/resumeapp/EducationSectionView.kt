package pl.dawidraszka.resumeapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_education.view.*
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.data.model.resume.sections.objective.ObjectiveSection
import pl.dawidraszka.resumeapp.ui.SectionView

class EducationSectionView(context: Context) : SectionView(context) {

    init {
        inflate(context, R.layout.section_education, frameLayout)
    }

    override fun updateData(resume: Resume) {
        school_test_text_view.text = resume.educationSection?.schools?.get(0)?.name
    }
}