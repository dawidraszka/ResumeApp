package pl.dawidraszka.resumeapp.ui.projects

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_project_details.*
import pl.dawidraszka.resumeapp.R
import pl.dawidraszka.resumeapp.ResumeApplication
import javax.inject.Inject

class ProjectDetailsFragment : Fragment() {
    @Inject
    lateinit var projectDetailsViewModel: ProjectDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext()
        (context.applicationContext as ResumeApplication).appComponent.inject(this)

        return inflater.inflate(R.layout.fragment_project_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(projectDetailsViewModel.getCurrentProject()) {
            if (this != null) {
                language_text_view.text = language

                if (screenshots != null) image_view_pager.adapter =
                    ImageAdapter(screenshots, requireContext())
                TabLayoutMediator(dots_indicator, image_view_pager) { _, _ -> }.attach()

                technologies?.forEachIndexed { index, technology ->
                    if (index % 2 == 0) technologies_used_left_text_view.append("• $technology\n")
                    else technologies_used_right_text_view.append("• $technology\n")
                }

                description_text_view.text = description
                activity?.toolbar?.title = "$name"
            }
        }
    }

    class ImageAdapter(private val imageURLs: List<String>, val context: Context) :
        RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val imageView = ImageView(context)
            imageView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            return ImageViewHolder(imageView)
        }


        override fun getItemCount(): Int = imageURLs.size

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            holder.bind(imageURLs[position])
        }

        class ImageViewHolder(private val imageView: ImageView) :
            RecyclerView.ViewHolder(imageView) {
            fun bind(imageUrl: String) {
                Glide.with(imageView)
                    .load(imageUrl)
                    .into(imageView)
            }
        }
    }
}
