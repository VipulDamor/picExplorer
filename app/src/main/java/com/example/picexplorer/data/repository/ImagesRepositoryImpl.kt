package com.example.picexplorer.data.repository

import com.example.picexplorer.data.source.remote.ApiService
import com.example.picexplorer.domain.mappers.ImageMapper.toImageListItems
import com.example.picexplorer.domain.models.ImageListItem
import com.example.picexplorer.domain.repository.ImagesRepository
import com.example.picexplorer.utils.ApiResponse
import com.example.picexplorer.utils.Constant.APIKEY
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ImagesRepository {

    override suspend fun fetchImages(page: Int): ApiResponse<List<ImageListItem>> {
        return try {
            val response = apiService.fetchImages(page = page, apiKey = APIKEY)
            ApiResponse.Success(response.body()?.hits?.toImageListItems() ?: emptyList())
        } catch (e: Exception) {
            ApiResponse.Error(e.localizedMessage?:"Error")
        }
    }
}