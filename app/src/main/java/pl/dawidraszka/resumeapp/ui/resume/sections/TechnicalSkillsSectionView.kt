package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_simple_list.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.ui.NonScrollableLayoutManager
import pl.dawidraszka.resumeapp.ui.SimpleListAdapter

class TechnicalSkillsSectionView(context: Context) : SectionView(context) {

    override fun getSectionName() = R.string.technical_skills

    override fun updateData(resume: Resume) {
        simple_list_recycler_view.apply {
            layoutManager = NonScrollableLayoutManager(context)
            if (resume.technicalSkillsSection?.technicalSkills != null)
                adapter = SimpleListAdapter(resume.technicalSkillsSection.technicalSkills)
        }
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_simple_list, frameLayout)
    }
}