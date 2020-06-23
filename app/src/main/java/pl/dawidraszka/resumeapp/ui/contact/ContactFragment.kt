package pl.dawidraszka.resumeapp.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.ResumeApplication
import javax.inject.Inject

class ContactFragment : Fragment() {

    @Inject
    lateinit var contactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireContext().applicationContext as ResumeApplication).appComponent.inject(this)

        val root = inflater.inflate(R.layout.fragment_contact, container, false)
        /*val textView: TextView = root.findViewById(R.id.contact_me_label)
        contactViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}
