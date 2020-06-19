package pl.dawidraszka.resumeapp.ui.resume.sections

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_section.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume

abstract class SectionView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    abstract fun updateData(resume: Resume)
    abstract fun prepareChildView()
    abstract fun getSectionName(): Int

    init {
        prepareParentView()
    }

    fun prepareParentView() {

        inflate(context, R.layout.item_section, this)

        expand_collapse_button.setOnClickListener {
            frameLayout.visibility =
                if (frameLayout.visibility == View.GONE) {
                    View.VISIBLE
                } else {
                    View.GONE
                }

            it.rotation = it.rotation + 180
        }

        section_name_text_view.text = context.getText(getSectionName())
        prepareChildView()
    }

    fun hideLoading() {
        this.loading_bar.visibility = View.GONE
    }
}
