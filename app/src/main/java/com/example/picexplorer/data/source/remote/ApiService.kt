package com.example.picexplorer.data.source.remote

import com.example.picexplorer.data.models.imagelist.ImageListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(".") // The endpoint is empty because the base URL includes "api/"
    suspend fun fetchImages(
        @Query("key") apiKey: String,
        @Query("page") page: Int
    ): Response<ImageListResponse>
}