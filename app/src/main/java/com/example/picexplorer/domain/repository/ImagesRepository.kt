package com.example.picexplorer.domain.repository

import com.example.picexplorer.domain.models.ImageListItem
import com.example.picexplorer.utils.ApiResponse

interface ImagesRepository {
    suspend fun fetchImages(page :Int) : ApiResponse<List<ImageListItem>>
}