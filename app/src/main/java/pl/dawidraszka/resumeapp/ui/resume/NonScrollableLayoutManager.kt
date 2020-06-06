package pl.dawidraszka.resumeapp.ui.resume

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class NonScrollableLayoutManager(context: Context) : LinearLayoutManager(context) {
    override fun canScrollVertically(): Boolean {
        return false
    }
}