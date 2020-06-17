package pl.dawidraszka.resumeapp.ui.buttons

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatImageButton


class EmailButton(context: Context, attrs: AttributeSet) : AppCompatImageButton(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("raszka.dawid@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Job offer")
            }
            context.startActivity(intent)
        }
    }
}