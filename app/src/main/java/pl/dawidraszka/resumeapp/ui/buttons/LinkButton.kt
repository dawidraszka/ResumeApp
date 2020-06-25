package pl.dawidraszka.resumeapp.ui.buttons

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import pl.dawidraszka.resumeapp.R

class LinkButton (context: Context, val attrs: AttributeSet) : AppCompatImageButton(context, attrs) {

    var link: String? = null

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.LinkButton,
            0, 0).apply {

            try {
                link = getString(R.styleable.LinkButton_link)
            } finally {
                recycle()
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        setOnClickListener {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(link)
                )
            )
        }
    }
}