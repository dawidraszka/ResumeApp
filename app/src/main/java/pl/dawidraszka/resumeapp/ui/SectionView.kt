package pl.dawidraszka.resumeapp.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_section.view.*

class SectionView(context : Context, attrs : AttributeSet) : ConstraintLayout(context, attrs){
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        expand_collapse_button.setOnClickListener{
            to_do_remove_test.visibility = if(to_do_remove_test.visibility == View.GONE) View.VISIBLE else View.GONE
        }
    }
}