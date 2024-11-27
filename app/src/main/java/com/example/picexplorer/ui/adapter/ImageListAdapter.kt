package com.example.picexplorer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.picexplorer.databinding.ItemImageListBinding

import com.example.picexplorer.domain.models.ImageListItem

class ImageListAdapter(
    private val imageList: List<ImageListItem>
) : RecyclerView.Adapter<ImageListAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(private val binding: ItemImageListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageItem: ImageListItem) {
            binding.imagePath2 = imageItem.previewUrl
            binding.textUserName.text = imageItem.userName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size
}
