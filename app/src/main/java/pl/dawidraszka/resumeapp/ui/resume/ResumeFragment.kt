package pl.dawidraszka.resumeapp.ui.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import pl.dawidraszka.resumeapp.R

class ResumeFragment : Fragment() {

    private lateinit var resumeViewModel: ResumeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        resumeViewModel =
                ViewModelProviders.of(this).get(ResumeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_resume, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        resumeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
