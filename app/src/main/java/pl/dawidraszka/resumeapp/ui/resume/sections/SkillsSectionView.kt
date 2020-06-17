package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_list.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.ui.SimpleListAdapter
import pl.dawidraszka.resumeapp.ui.resume.NonScrollableLayoutManager
import javax.inject.Inject

class SkillsSectionView @Inject constructor(context: Context) : SectionView(context) {

    override fun getSectionName() = R.string.skills

    override fun updateData(resume: Resume) {
        list_recycler_view.apply {
            layoutManager = NonScrollableLayoutManager(context)
            if (resume.skillsSection?.skills != null)
                adapter = SimpleListAdapter(resume.skillsSection.skills)
        }
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_list, frameLayout)

        
    }
}


fun changeString(stringToRevert: String): String {
    return stringToRevert.dropLast(3)
}