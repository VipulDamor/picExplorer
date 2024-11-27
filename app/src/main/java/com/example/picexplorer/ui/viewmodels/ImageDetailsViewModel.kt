package com.example.picexplorer.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picexplorer.domain.models.ImageDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageDetailsViewModel @Inject constructor():ViewModel() {
    private val _imageDetail = MutableLiveData<ImageDetail>()
    val imageDetail: LiveData<ImageDetail> get() = _imageDetail

    fun setImageDetails(image: ImageDetail) {
        _imageDetail.value = ImageDetail(
            imageUrl = image.imageUrl ?: "",
            imageSize = image.imageSize,
            imageType = image.imageType ?: "Unknown",
            imageTags = image.imageTags ?: "No tags",
            userName = image.userName ?: "Anonymous",
            views = image.views ?: 0,
            likes = image.likes ?: 0,
            comments = image.comments ?: 0,
            favorites = image.favorites ?: 0,
            downloads = image.downloads ?: 0
        )
    }

}