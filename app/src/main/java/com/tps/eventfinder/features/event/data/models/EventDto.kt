package com.tps.eventfinder.features.event.data.models

data class EventDto(
    val id: String,
    val name: String,
    val url: String?,
    val images: List<ImageDto>?
)

data class ImageDto(
    val url: String,
    val width: Int,
    val height: Int
)
