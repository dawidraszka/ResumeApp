package pl.dawidraszka.resumeapp.ui

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_section.view.*
import pl.dawidraszka.resumeapp.data.model.resume.Resume

class ObjectiveSectionView(context: Context) : SectionView(context) {
    val objectiveTextView = TextView(context)

    init {
        frameLayout.addView(objectiveTextView)
    }

    override fun updateData(resume: Resume) {
        objectiveTextView.text = resume.objectiveSection?.objective
    }
}