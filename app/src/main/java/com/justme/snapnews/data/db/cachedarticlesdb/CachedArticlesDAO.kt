package com.justme.snapnews.data.db.cachedarticlesdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.justme.snapnews.data.models.NewsItem

@Dao
interface CachedArticlesDAO {

    @Query("UPDATE cached_articles SET  = :articles WHERE ")
    fun insertArticles(category: String, articles : MutableList<NewsItem>)
}