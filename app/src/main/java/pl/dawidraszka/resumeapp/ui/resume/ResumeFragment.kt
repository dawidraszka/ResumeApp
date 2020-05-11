package pl.dawidraszka.resumeapp.ui.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_resume.*
import kotlinx.android.synthetic.main.nav_header_main.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.ui.resume.education.SchoolRecyclerAdapter

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
            objective_text_view?.text = it.objectiveSection?.objective
            if(it.educationSection?.schools != null){
                schools_recycler_view.adapter = SchoolRecyclerAdapter(it.educationSection.schools)
            }
        })

        schools_recycler_view.layoutManager = LinearLayoutManager(activity)

    }
}
