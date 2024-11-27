package com.example.picexplorer.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.picexplorer.domain.models.ImageListItem
import com.example.picexplorer.domain.repository.ImagesRepository
import com.example.picexplorer.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewmodel @Inject constructor(private val imagesRepository: ImagesRepository) :
    ViewModel() {

    private val _imagesList = MutableLiveData<List<ImageListItem>>()
    val imagesList: LiveData<List<ImageListItem>> = _imagesList

    private val _page = MutableLiveData(0)
    val page: LiveData<Int> = _page

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun incrementPageCount() {
        _page.postValue(_page.value?.plus(1) ?: 0)
    }

    init {
        fetchImages()
    }

    private fun fetchImages() {
        viewModelScope.launch(Dispatchers.IO) {
            val page = _page.value?.plus(1) ?: 0
            when (val response: ApiResponse<List<ImageListItem>> =
                imagesRepository.fetchImages(page)) {
                is ApiResponse.Error -> {
                    response.errorMessage
                    _isLoading.postValue(false)
                }
                ApiResponse.Loading -> {
                    _isLoading.postValue(true)
                }

                is ApiResponse.Success -> {
                    _imagesList.postValue(response.data)
                    _isLoading.postValue(false)
                }
            }
        }
    }
}