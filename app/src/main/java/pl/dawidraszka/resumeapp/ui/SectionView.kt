package pl.dawidraszka.resumeapp.ui

import android.content.Context
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_section.view.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.data.model.resume.Resume

abstract class SectionView(context: Context) : ConstraintLayout(context) {

    abstract fun updateData(resume: Resume)

    @CallSuper
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        inflate(context, R.layout.item_section, this)

        expand_collapse_button.setOnClickListener {
            frameLayout.visibility =
                if (frameLayout.visibility == View.GONE) View.VISIBLE else View.GONE
            it.rotation = it.rotation + 180
        }
    }

    fun setSectionName(@StringRes sectionName: Int){
        section_name_text_view.text = context.getText(sectionName)
    }
}
