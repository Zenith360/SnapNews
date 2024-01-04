package com.justme.snapnews.util

import com.justme.snapnews.data.db.cachedarticlesdb.CachedArticlesEntity
import com.justme.snapnews.data.models.NewsItem

fun converterToNewsItem(articles : MutableList<CachedArticlesEntity>) : MutableList<NewsItem>{
    val newsItems = mutableListOf<NewsItem>()

    for (article in articles){
        val newsItem = NewsItem(
            article.article_id ?: "",
            article.content ?: "",
            article.link ?: "",
            article.title ?: "",
            article.category ?: "",
            article.country ?: "",
            article.description ?: "",
            article.image_url ?: "",
            article.source_id ?: "",
            article.isBookmarked ?: false
        )
        newsItems.add(newsItem)
    }

    return newsItems
}