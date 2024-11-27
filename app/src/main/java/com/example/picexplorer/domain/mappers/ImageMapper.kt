package com.example.picexplorer.domain.mappers

import com.example.picexplorer.data.models.imagelist.HitsItem
import com.example.picexplorer.domain.models.ImageDetail
import com.example.picexplorer.domain.models.ImageListItem

object ImageMapper {


    fun List<HitsItem?>.toImageListItems() : List<ImageListItem> {
        return this.mapNotNull { hit ->
            if (hit != null) {
                ImageListItem(
                    previewUrl = hit.previewURL ?: "",
                    userName = hit.user ?: "Unknown"
                )
            } else null
        } ?: emptyList()
    }


    fun toImageDetail(hit: HitsItem?): ImageDetail? {
        return hit?.let {
            ImageDetail(
                imageUrl = it.largeImageURL ?: "",
                imageSize = it.imageSize ?: 0,
                imageType = it.type ?: "Unknown",
                imageTags = it.tags ?: "None",
                userName = it.user ?: "Unknown",
                views = it.views ?: 0,
                likes = it.likes ?: 0,
                comments = it.comments ?: 0,
                favorites = it.collections ?: 0,
                downloads = it.downloads ?: 0
            )
        }
    }
}
