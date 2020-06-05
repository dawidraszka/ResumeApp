package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_objective.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume

class ObjectiveSectionView(context: Context) : SectionView(context) {

    override fun getSectionName() = R.string.objective

    override fun updateData(resume: Resume) {
        objective_text_view.text = resume.objectiveSection?.objective
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_objective, frameLayout)
    }
}