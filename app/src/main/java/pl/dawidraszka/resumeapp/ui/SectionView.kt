package pl.dawidraszka.resumeapp.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_section.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.data.model.resume.Section

abstract class SectionView(context: Context) : ConstraintLayout(context) {

    init{
        inflate(context, R.layout.item_section, this)
    }

    abstract fun updateData(resume: Resume)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        expand_collapse_button.setOnClickListener {
            frameLayout.visibility =
                if (frameLayout.visibility == View.GONE) View.VISIBLE else View.GONE
        }
    }
}
