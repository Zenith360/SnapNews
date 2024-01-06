package com.justme.snapnews.util

import com.justme.snapnews.data.db.bookmarksdb.BookmarkEntity
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

fun converterToCachedArticlesEntity(articles : MutableList<NewsItem>) : MutableList<CachedArticlesEntity>{
    val cachedArticles = mutableListOf<CachedArticlesEntity>()

    for (article in articles){
        val cachedArticle = CachedArticlesEntity(
            article.article_id,
            article.content,
            article.link,
            article.title,
            article.country,
            article.description ?: "",
            article.image_url,
            article.source_id,
            article.isBookmarked,
            article.category
        )
        cachedArticles.add(cachedArticle)
    }

    return cachedArticles
}

fun converterToBookmarkEntity(newsItem: NewsItem) : BookmarkEntity{
    return BookmarkEntity(
        newsItem.article_id,
        newsItem.content,
        newsItem.link,
        newsItem.title,
        newsItem.category,
        newsItem.country,
        newsItem.description,
        newsItem.image_url,
        newsItem.source_id,
        newsItem.isBookmarked
    )
}