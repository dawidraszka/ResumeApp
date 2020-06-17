package pl.dawidraszka.resumeapp.ui.buttons

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatImageButton


class GitHubButton(context: Context, attrs: AttributeSet) : AppCompatImageButton(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setOnClickListener {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/dawidraszka?tab=repositories")
                )
            )
        }
    }
}