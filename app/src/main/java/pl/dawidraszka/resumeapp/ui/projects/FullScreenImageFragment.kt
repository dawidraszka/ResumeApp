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
import kotlinx.android.synthetic.main.fragment_full_screen_gallery.view.*
import pl.dawidraszka.resumeapp.R

class FullScreenImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_full_screen_gallery, container, false)

        val screenshots = arguments?.getStringArrayList("imageUrls")

        if (screenshots != null) root.image_view_pager.adapter =
            ImageAdapter(
                screenshots,
                requireContext()
            )

        val index = arguments?.getInt("index")

        if (index != null)
            root.image_view_pager.currentItem = index


        TabLayoutMediator(root.dots_indicator, root.image_view_pager) { _, _ -> }.attach()

        return root
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