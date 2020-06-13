package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import android.view.Gravity
import android.widget.TextView
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.section_hobbies.view.*
import kotlinx.android.synthetic.main.section_list.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.ui.SimpleListAdapter
import pl.dawidraszka.resumeapp.ui.resume.NonScrollableLayoutManager
import javax.inject.Inject

class HobbiesSectionView @Inject constructor(context: Context) : SectionView(context) {

    override fun getSectionName() = R.string.hobbies

    override fun updateData(resume: Resume) {
        list_recycler_view.apply {
            layoutManager = NonScrollableLayoutManager(context)
            if (resume.hobbiesSection?.hobbies != null)
                adapter = SimpleListAdapter(resume.hobbiesSection.hobbies)
        }
    }

    override fun prepareChildView() {
        inflate(context, R.layout.section_list, frameLayout)
    }
}