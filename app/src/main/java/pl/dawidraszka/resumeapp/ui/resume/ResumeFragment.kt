package pl.dawidraszka.resumeapp.ui.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnLayout
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_resume.*
import pl.dawidraszka.resumeapp.R

class ResumeFragment : Fragment() {

    private lateinit var resumeViewModel: ResumeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resumeViewModel = ViewModelProvider(this).get(ResumeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_resume, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resumeViewModel.getResume().observe(viewLifecycleOwner, Observer {
            resume_recycler_view.adapter = ResumeRecyclerAdapter(it)
        })

        resume_recycler_view.layoutManager = LinearLayoutManager(activity)
    }
}
