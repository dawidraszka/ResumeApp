package pl.dawidraszka.resumeapp.ui.buttons

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatImageButton


class PhoneButton(context: Context, attrs: AttributeSet) : AppCompatImageButton(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+48507701818")
            }
            context.startActivity(intent)
        }
    }
}