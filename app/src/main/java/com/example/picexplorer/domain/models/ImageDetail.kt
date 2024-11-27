package com.example.picexplorer.domain.models

data class ImageDetail(
    val imageUrl: String,
    val imageSize: Int,
    val imageType: String,
    val imageTags: String,
    val userName: String,
    val views: Int,
    val likes: Int,
    val comments: Int,
    val favorites: Int,
    val downloads: Int
)
