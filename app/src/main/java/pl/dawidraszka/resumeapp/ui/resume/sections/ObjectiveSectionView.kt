package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_objective.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import javax.inject.Inject

class ObjectiveSectionView (context: Context, attrs: AttributeSet) : SectionView(context, attrs) {

    override fun getSectionName() = R.string.objective

    override fun updateData(resume: Resume) {
        hideLoading()
        objective_text_view.text = resume.objectiveSection?.objective
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_objective, frameLayout)
    }
}