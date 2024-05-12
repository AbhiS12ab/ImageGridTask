package com.android.imagegridtask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android.imagegridtask.R
import com.android.imagegridtask.data.MediaCoverage
import com.squareup.picasso.Picasso

class MediaCoverageAdapter : RecyclerView.Adapter<MediaCoverageAdapter.MediaCoverageViewHolder>() {

    private var mediaCoverages: List<MediaCoverage> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(mediaCoverages: List<MediaCoverage>) {
        this.mediaCoverages = mediaCoverages
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaCoverageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return MediaCoverageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MediaCoverageViewHolder, position: Int) {
        val mediaCoverage = mediaCoverages[position]
        Picasso.get().load(mediaCoverage.getThumbnailUrl())
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.error_image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mediaCoverages.size
    }

    class MediaCoverageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)


    }
    override fun onViewDetachedFromWindow(holder: MediaCoverageViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Picasso.get().cancelRequest(holder.imageView)
    }
}
