package com.justme.snapnews.data.models

data class NewsItem(
    val article_id: String,
    val content: String,
    val link: String,
    val title: String,
    val category: String,
    val country: String,
    val description: String?,
    val image_url: String,
    val source_id: String,
    var isBookmarked: Boolean
)